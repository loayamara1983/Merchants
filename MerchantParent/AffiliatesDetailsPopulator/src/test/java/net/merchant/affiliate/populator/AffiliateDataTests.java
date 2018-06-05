package net.merchant.affiliate.populator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import net.merchant.affiliate.populator.service.domain.Affiliate;
import net.merchant.affiliate.populator.service.domain.Affiliates;
import net.merchant.affiliate.populator.service.domain.AffiliatesAllTimeComisions;
import net.merchant.affiliate.populator.service.domain.AffiliatesComisionsStats;
import net.merchant.affiliate.populator.service.domain.AffiliatesThisMonthComisions;
import net.merchant.affiliate.populator.service.domain.CompainsComisionsStats;
import net.merchant.affiliate.populator.service.domain.Login;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AffiliateDataTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String url = "http://boostini.postaffiliatepro.com/scripts/server.php";
	private HttpHeaders headers;

	@Before
	public void setup() {
		headers = new HttpHeaders();

		headers.setAccept(Collections.singletonList(MediaType.ALL));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		headers.add("Origin", "http://boostini.postaffiliatepro.com");
		headers.add("Accept-Encoding", "gzip, deflate");
		headers.add("Accept-Language", "en-US,en;q=0.9,ar;q=0.8");
		headers.add("Referer", "http://boostini.postaffiliatepro.com/affiliates/panel.php");
	}

	@Test
	public void affiliateShouldAuthenticate() throws Exception {
		String sessionId = getSessionId();
		assertFalse(sessionId.isEmpty());
	}

	private String getSessionId() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		String formData = "{\"C\":\"Pap_Api_AuthService\",\"M\":\"authenticate\",\"fields\":[[\"name\",\"value\",\"values\",\"error\"],[\"username\",\"ta.na.mails@gmail.com\",null,\"\"],[\"password\",\"B00stini76*#\",null,\"\"],[\"roleType\",\"M\",null,\"\"],[\"isFromApi\",\"Y\",null,\"\"],[\"apiVersion\",\"c278cce45ba296bc421269bfb3ddff74\",null,\"\"]]}";
		map.add("D", formData);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<Login> response = restTemplate.postForEntity(url, request, Login.class);

		return response.getBody().getFields().get(7).get(1);
	}

	@Test
	public void affiliateShouldReturnAllAffiliates() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		String formData = "{\"C\":\"Pap_Merchants_User_AffiliatesGrid\", \"M\":\"getRows\", \"sort_col\":\"dateinserted\", \"sort_asc\":false, \"offset\":0, \"limit\":30,\"filters\":[[\"dateinserted\",\"DP\",\"TY\"],[\"rstatus\",\"IN\",\"A,D,P\"]], \"columns\":[[\"id\"],[\"id\"],[\"refid\"],[\"userid\"],[\"username\"],[\"firstname\"],[\"lastname\"],[\"rstatus\"],[\"parentuserid\"],[\"parentusername\"],[\"parentfirstname\"],[\"parentlastname\"],[\"dateinserted\"],[\"actions\"]], \"S\":\""
				+ getSessionId() + "\"}";
		map.add("D", formData);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<Affiliates> response = restTemplate.postForEntity(url, request, Affiliates.class);

		assertTrue(response.getBody().getCount() > 0);

		List<List<String>> rows = response.getBody().getRows();
		rows.remove(0);

		List<Affiliate> affiliates = new ArrayList<>();

		for (List<String> row : rows) {
			Affiliate affiliate = new Affiliate();

			affiliate.setId(row.get(0));
			affiliate.setUserId(row.get(1));
			affiliate.setReferenceId(row.get(2));
			affiliate.setFirstName(row.get(3));
			affiliate.setLastName(row.get(4));
			affiliate.setUsername(row.get(5));
			affiliate.setParentUserId(row.get(6));
			affiliate.setStatus(row.get(7));
			affiliate.setCreated(row.get(8));

			affiliates.add(affiliate);
		}

		assertTrue(affiliates.size() > 0);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void shouldReturnStats() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		String formData = String.format(
				"{\"C\":\"Gpf_Rpc_Server\", \"M\":\"run\", \"requests\":[{\"C\":\"Pap_Merchants_User_AffiliateInfoData\", \"M\":\"load\"},{\"C\":\"Pap_Merchants_User_AffiliateInfoData\", \"M\":\"load\", \"filters\":[[\"dateinserted\",\"DP\",\"TM\"]]}], \"S\":\"%s\"}",
				getSessionId());
		map.add("D", formData);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<List> response = restTemplate.postForEntity(url, request, List.class);

		assertFalse(response.getBody().isEmpty());

		List<List<List>> body = response.getBody();

		List<List> allTimeStats = body.get(0);
		List<List> thisMonthStats = body.get(1);

		Long countAffiliates = Long.parseLong(allTimeStats.get(1).get(1).toString());
		Long approvedAffiliates = Long.parseLong(allTimeStats.get(2).get(1).toString());
		Long pendingAffiliates = Long.parseLong(allTimeStats.get(3).get(1).toString());
		Long totalSales = Long.parseLong(allTimeStats.get(4).get(1).toString());
		Long approvedCommissions = Long.parseLong(allTimeStats.get(5).get(1).toString());
		Long pendingCommissions = Long.parseLong(allTimeStats.get(6).get(1).toString());

		AffiliatesAllTimeComisions allTimeComisions = new AffiliatesAllTimeComisions(countAffiliates,
				approvedAffiliates, pendingAffiliates, totalSales, approvedCommissions, pendingCommissions);

		countAffiliates = Long.parseLong(thisMonthStats.get(1).get(1).toString());
		approvedAffiliates = Long.parseLong(thisMonthStats.get(2).get(1).toString());
		pendingAffiliates = Long.parseLong(thisMonthStats.get(3).get(1).toString());
		totalSales = Long.parseLong(thisMonthStats.get(4).get(1).toString());
		approvedCommissions = Long.parseLong(thisMonthStats.get(5).get(1).toString());
		pendingCommissions = Long.parseLong(thisMonthStats.get(6).get(1).toString());

		AffiliatesThisMonthComisions thisMonthComisions = new AffiliatesThisMonthComisions(countAffiliates,
				approvedAffiliates, pendingAffiliates, totalSales, approvedCommissions, pendingCommissions);

		AffiliatesComisionsStats affiliatesStats = new AffiliatesComisionsStats(allTimeComisions, thisMonthComisions);

		assertTrue(affiliatesStats.getAllTimeComisions() != null && affiliatesStats.getThisMonthComisions() != null);
	}
}