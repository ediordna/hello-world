package parcelp;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

//import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Test;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class IntegrationTest {

		@Test
		public void simpleIntegrationTest() {
			Client client = Client.create();
			WebResource webResource = client.resource("http://www.allgaeu-parcel-service.de:1100/rest/message"); //Port 1101, da in create_test_container entsprechende Umleitung festgelegt

			Paket parcelDims = new Paket(20, 15, 10, "");
			ClientResponse response = webResource.entity(new Gson().toJson(parcelDims), MediaType.APPLICATION_JSON).post(ClientResponse.class);

			String responseData = response.getEntity(String.class);
			Paket result = new Gson().fromJson(responseData, Paket.class);

			assertEquals(200, response.getStatus()); //http Code "okay"
			assertEquals(new Paket(20, 15, 10, "L"), result); //Prüfung auf den exakten Wert
		}
}
