package org.rygn.firstsoapws;

import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

import javax.xml.transform.Source;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

@SpringBootTest
public class CountryEndpointTest {

	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockWebServiceClient;

	@BeforeEach
	public void createClient() throws Exception {
		mockWebServiceClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void customerCountEndpoint() throws Exception {
		
		Source requestPayload = new StringSource("<getCountryRequest xmlns='http://spring.io/guides/gs-producing-web-service'>"
				+ "<name>Poland</name>" + "</getCountryRequest>");
		
		Source expectedResponsePayload = new StringSource(
				"<getCountryResponse xmlns='http://spring.io/guides/gs-producing-web-service'>"
						+ "  <country>"
						+ "    <name>Poland</name>"
						+ "    <population>38186860</population>"
						+ "    <capital>Warsaw</capital>"
						+ "    <currency>PLN</currency>"
						+ "  </country>" 
						+ "</getCountryResponse>");

		mockWebServiceClient
			.sendRequest(withPayload(requestPayload))
			.andExpect(payload(expectedResponsePayload));
	}
}
