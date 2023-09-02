package project.patientTreatment;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientTreatmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnAPatientWhenDataIsSaved(){
		ResponseEntity<String> response = restTemplate.getForEntity("/patients/99", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		Number id = documentContext.read("$.id");
		assertThat(id).isNotNull();
		assertThat(id).isEqualTo(99);

		String name = documentContext.read("$.firstName");
		assertThat(name).isNotNull();
		assertThat(name).isEqualTo("derek");

		String lname = documentContext.read("$.lastName");
		assertThat(lname).isNotNull();
		assertThat(lname).isEqualTo("hopes");

		Number age = documentContext.read("$.age");
		assertThat(age).isNotNull();
		assertThat(age).isEqualTo(35);
	}

	@Test
	void shouldNotReturnAPatientWithAnUnknownId(){
		ResponseEntity<String> response = restTemplate
				.getForEntity("/patients/199999", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();
	}


}
