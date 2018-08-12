package cat.apuntsdetecnologia.restclientdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cat.apuntsdetecnologia.restclientdemo.services.RESTService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientDemoApplicationTests {
	@Autowired
	private RESTService restService;

	// smoke test
	@Test
	public void contextLoads() {
		assertThat(restService).isNotNull();
	}

}
