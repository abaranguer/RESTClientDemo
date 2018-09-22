package cat.apuntsdetecnologia.restclientdemo.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cat.apuntsdetecnologia.restclientdemo.model.Address;

@Service
public class RESTService {

	// https://o7planning.org/en/11647/spring-boot-restful-client-with-resttemplate-example

	private static final String URL_DEMO = "http://localhost:8080/RESTServerDemo/demo?first=%s&second=%s";
	private static final String URL_TOUPPER = "http://localhost:8080/RESTServerDemo/toupper";
	private static final String URL_TOUPPERWITHERROR = "http://localhost:8080/RESTServerDemo/toupperwitherror";
	
	public Address demo(String firstName, String secondName) {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(String.format(URL_DEMO, firstName, secondName), Address.class);
	}

	public Address toUpper(Address address) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		headers.setContentType(MediaType.APPLICATION_XML);

		HttpEntity<Address> requestBody = new HttpEntity<>(address);

		return restTemplate.postForObject(URL_TOUPPER, requestBody, Address.class);
	}
	
	public String toUpperWithError(Address address) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Address> requestBody = new HttpEntity<>(address);

		return  restTemplate.postForObject(URL_TOUPPERWITHERROR, requestBody, String.class);
	}

}
