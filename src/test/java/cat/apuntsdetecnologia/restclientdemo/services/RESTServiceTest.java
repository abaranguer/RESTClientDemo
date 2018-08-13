package cat.apuntsdetecnologia.restclientdemo.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cat.apuntsdetecnologia.restclientdemo.model.Address;
import cat.apuntsdetecnologia.restclientdemo.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RESTServiceTest {
	@Autowired
	private RESTService restService;

	@Test
	public void demoTest() {
		Address address = restService.demo("Albert", "Baranguer");

		assertThat(address).isNotNull();
		assertThat(address.getPerson().getFirstName()).matches("Albert");
	}

	@Test
	public void toUpperTest() {
		Address address = new Address();
		Person person = new Person();

		person.setFirstName("Albert");
		person.setSecondName("Baranguer");
		address.setPerson(person);
		address.setCity("myCity");
		address.setCountry("myCountry");
		address.setDoor(1);
		address.setFloor(2);
		address.setNumber(3);
		address.setStreet("myStreet");
		address.setZipCode("myZipCode");

		Address addressToUpper = restService.toUpper(address);

		assertThat(addressToUpper).isNotNull();
		assertThat(addressToUpper.getPerson().getFirstName()).matches("ALBERT");
	}
	
	@Test
	public void toUpperWithErrorTest() {
		Address address = new Address();
		Person person = new Person();

		person.setFirstName("Albert");
		person.setSecondName("Baranguer");
		address.setPerson(person);
		address.setCity("myCity");
		address.setCountry("myCountry");
		address.setDoor(1);
		address.setFloor(2);
		address.setNumber(3);
		address.setStreet("myStreet");
		address.setZipCode("myZipCode");

		String retValue = restService.toUpperWithError(address);

		assertThat(retValue).isNotNull();
	}
}
