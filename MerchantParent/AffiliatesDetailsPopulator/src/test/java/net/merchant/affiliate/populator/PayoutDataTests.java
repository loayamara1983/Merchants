package net.merchant.affiliate.populator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

import net.merchant.affiliate.populator.service.domain.Login;
import net.merchant.affiliate.populator.service.domain.PayoutAllTime;
import net.merchant.affiliate.populator.service.domain.PayoutStats;
import net.merchant.affiliate.populator.service.domain.PayoutThisMonth;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PayoutDataTests {

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void shouldReturnStats() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		String formData = String.format(
				"{\"C\":\"Gpf_Rpc_Server\", \"M\":\"run\", \"requests\":[{\"C\":\"Pap_Merchants_Payout_PayoutsInfoData\", \"M\":\"load\"},{\"C\":\"Pap_Merchants_Payout_PayoutsInfoData\", \"M\":\"load\", \"filters\":[[\"dateinserted\",\"DP\",\"TM\"]]}], \"S\":\"%s\"}",
				getSessionId());
		map.add("D", formData);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<List> response = restTemplate.postForEntity(url, request, List.class);

		assertFalse(response.getBody().isEmpty());

		List<List<List>> body = response.getBody();

		List<List> allTimeStats = body.get(0);
		List<List> thisMonthStats = body.get(1);

		Long paid = Long.parseLong(allTimeStats.get(1).get(1).toString());
		Long unpaidApprovedComm = Long.parseLong(allTimeStats.get(2).get(1).toString());
		Long unpaidPendingComm = Long.parseLong(allTimeStats.get(3).get(1).toString());
		Long unpaidDeclinedComm = Long.parseLong(allTimeStats.get(4).get(1).toString());

		PayoutAllTime allTime = new PayoutAllTime(paid, unpaidApprovedComm, unpaidPendingComm, unpaidDeclinedComm);

		paid = Long.parseLong(thisMonthStats.get(1).get(1).toString());
		unpaidApprovedComm = Long.parseLong(thisMonthStats.get(2).get(1).toString());
		unpaidPendingComm = Long.parseLong(thisMonthStats.get(3).get(1).toString());
		unpaidDeclinedComm = Long.parseLong(thisMonthStats.get(4).get(1).toString());

		PayoutThisMonth thisMonth = new PayoutThisMonth(paid, unpaidApprovedComm, unpaidPendingComm, unpaidPendingComm);

		PayoutStats stats = new PayoutStats(allTime, thisMonth);

		assertTrue(stats.getAllTimeComisions() != null && stats.getThisMonthComisions() != null);
	}
}