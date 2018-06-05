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

import com.fasterxml.jackson.databind.ObjectMapper;

import net.merchant.affiliate.populator.service.domain.Campaign;
import net.merchant.affiliate.populator.service.domain.Campaigns;
import net.merchant.affiliate.populator.service.domain.CompainStats;
import net.merchant.affiliate.populator.service.domain.CompainsAllTimeComisions;
import net.merchant.affiliate.populator.service.domain.CompainsComisionsStats;
import net.merchant.affiliate.populator.service.domain.CompainsStats;
import net.merchant.affiliate.populator.service.domain.CompainsThisMonthComisions;
import net.merchant.affiliate.populator.service.domain.Login;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CompainsDataTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private final String url = "http://boostini.postaffiliatepro.com/scripts/server.php";
	private HttpHeaders headers;
	
	private ObjectMapper mapper;

	@Before
	public void setup() {
		headers = new HttpHeaders();

		headers.setAccept(Collections.singletonList(MediaType.ALL));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		headers.add("Origin", "http://boostini.postaffiliatepro.com");
		headers.add("Accept-Encoding", "gzip, deflate");
		headers.add("Accept-Language", "en-US,en;q=0.9,ar;q=0.8");
		headers.add("Referer", "http://boostini.postaffiliatepro.com/affiliates/panel.php");
		
		mapper = new ObjectMapper();
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

	@SuppressWarnings("rawtypes")
	@Test
	public void shouldReturnAllCampaigns() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		String formData = "{\"C\":\"Gpf_Rpc_Server\", \"M\":\"run\", \"requests\":[{\"C\":\"Pap_Affiliates_Promo_CampaignsGrid\", \"M\":\"getRows\", \"offset\":0, \"limit\":100, \"columns\":[[\"id\"],[\"id\"],[\"name\"],[\"description\"],[\"logourl\"],[\"banners\"],[\"longdescriptionexists\"],[\"commissionsdetails\"],[\"rstatus\"],[\"commissionsexist\"]]}], \"S\":\""
				+ getSessionId() + "\"}";
		map.add("D", formData);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<List> campaignsResponse = restTemplate.postForEntity(url, request, List.class);
		Object campaignsObject = campaignsResponse.getBody().get(0);

		Campaigns campaignsList = mapper.convertValue(campaignsObject, Campaigns.class);

		assertTrue(campaignsList.getCount() > 0);
		
		List<Campaign> campaigns = new ArrayList<>();

		List<List<String>> rows = campaignsList.getRows();
		rows.remove(0);
		
		for (List<String> row : rows) {
			Campaign campaign = new Campaign();

			campaign.setId(row.get(0));
			campaign.setCampaignId(row.get(1));
			campaign.setStatus(row.get(2));
			campaign.setName(row.get(3));
			campaign.setDescription(row.get(4));
			campaign.setLogoUrl(row.get(5));
			campaign.setCookieLifetime(row.get(6));
			campaign.setLongDescriptionExists(row.get(7));
			campaign.setBanners(row.get(8));
			campaign.setCommissionsExist(row.get(9));
			campaign.setCommissionsDetails(row.get(10));

			campaigns.add(campaign);
		}
		
		assertTrue(campaigns.size() > 0);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void shouldReturnStats() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		String formData = String.format("{\"C\":\"Gpf_Rpc_Server\", \"M\":\"run\", \"requests\":[{\"C\":\"Pap_Features_Hosting_InvoicesGrid\", \"M\":\"getRows\", \"sort_col\":\"number\", \"sort_asc\":true, \"offset\":0, \"limit\":30, \"columns\":[[\"id\"],[\"id\"],[\"number\"],[\"price\"],[\"created\"],[\"from_date\"],[\"to_date\"],[\"paid_date\"],[\"actions\"]]}], \"S\":\"%s\"}",getSessionId() );
		map.add("D", formData);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<List> response = restTemplate.postForEntity(url, request, List.class);

		assertFalse(response.getBody().isEmpty());
		
		Object campaignsStatsObject = response.getBody().get(0);
		
		CompainsStats campaignsStatsList = mapper.convertValue(campaignsStatsObject, CompainsStats.class);
		
		List<CompainStats> campaignsStatistics = new ArrayList<>();

		List<List<String>> rows = campaignsStatsList.getRows();
		rows.remove(0);
		
		for (List<String> row : rows) {
			CompainStats stats = new CompainStats();

			stats.setNumber(row.get(0));
			stats.setPrice(row.get(1));
			stats.setCreated(row.get(2));
			stats.setFromDate(row.get(3));
			stats.setToDate(row.get(4));
			stats.setPaidDate(row.get(5));

			campaignsStatistics.add(stats);
		}
		
		assertTrue(campaignsStatistics.size() > 0);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void shouldReturnComisionsStats() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

		String formData = String.format("{\"C\":\"Gpf_Rpc_Server\", \"M\":\"run\", \"requests\":[{\"C\":\"Pap_Merchants_Campaign_CampaignsInfoData\", \"M\":\"load\"},{\"C\":\"Pap_Merchants_Campaign_CampaignsInfoData\", \"M\":\"load\", \"filters\":[[\"dateinserted\",\"DP\",\"TM\"]]}], \"S\":\"%s\"}",getSessionId() );
		map.add("D", formData);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<List> response = restTemplate.postForEntity(url, request, List.class);

		assertFalse(response.getBody().isEmpty());
		
		List<List<List>> body = response.getBody();
		
		List<List> allTimeStats = body.get(0);
		List<List> thisMonthStats = body.get(1);
		
		Long totalComisions = Long.parseLong(allTimeStats.get(1).get(1).toString());
		Long totalSales = Long.parseLong(allTimeStats.get(2).get(1).toString());
		Long totalPendingCommisions = Long.parseLong(allTimeStats.get(2).get(1).toString());
		Long totalUnpaidApprovedCommisions = Long.parseLong(allTimeStats.get(3).get(1).toString());
		
		CompainsAllTimeComisions allTimeComisions = new CompainsAllTimeComisions(totalComisions, totalSales, totalPendingCommisions, totalUnpaidApprovedCommisions);
		
		totalComisions = Long.parseLong(thisMonthStats.get(1).get(1).toString());
		totalSales = Long.parseLong(thisMonthStats.get(2).get(1).toString());
		totalPendingCommisions = Long.parseLong(thisMonthStats.get(2).get(1).toString());
		totalUnpaidApprovedCommisions = Long.parseLong(thisMonthStats.get(3).get(1).toString());
		
		CompainsThisMonthComisions thisMonthComisions = new CompainsThisMonthComisions(totalComisions, totalSales, totalPendingCommisions, totalUnpaidApprovedCommisions);

		CompainsComisionsStats compainsComisionsStats = new CompainsComisionsStats(allTimeComisions, thisMonthComisions);

		assertTrue(compainsComisionsStats.getAllTimeComisions() != null && compainsComisionsStats.getThisMonthComisions() != null);
	}
}