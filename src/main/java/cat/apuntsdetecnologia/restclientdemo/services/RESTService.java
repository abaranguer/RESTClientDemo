package cat.apuntsdetecnologia.restclientdemo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cat.apuntsdetecnologia.restclientdemo.model.Address;

@Service
public class RESTService {

	// https://o7planning.org/en/11647/spring-boot-restful-client-with-resttemplate-example

	private static final String URL_DEMO = "http://localhost:8080/RESTServerDemo/demo?first=%s&second=%s";
	private static final String URL_TOUPPER = "http://localhost:8080/RESTServerDemo/toupper";

	public Address demo(String firstName, String secondName) {
		RestTemplate restTemplate = new RestTemplate();

		Address address = restTemplate.getForObject(String.format(URL_DEMO, firstName, secondName), Address.class);

		return address;
	}

	public Address toupper(Address address) {
		RestTemplate restTemplate = new RestTemplate();

		// HttpHeaders headers = new HttpHeaders();
		// headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		// headers.setContentType(MediaType.APPLICATION_XML);

		// HttpEntity<Address> requestBody = new HttpEntity<>(address, headers);
		HttpEntity<Address> requestBody = new HttpEntity<>(address);

		Address addressToUpper = restTemplate.postForObject(URL_TOUPPER, requestBody, Address.class);

		return addressToUpper;
	}

}
