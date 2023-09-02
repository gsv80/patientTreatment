package project.patientTreatment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;

@JsonTest
public class ProjectJsonTest {
    @Autowired
    private JacksonTester<Patient> json;

    @Test
    public void patientSerializationTest() throws IOException {
        Patient patient = new Patient(99L, "first", "last", "midname", 10);

        assertThat(json.write(patient)).isStrictlyEqualToJson("/patient/expected.json");

        assertThat(json.write(patient)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(patient)).extractingJsonPathNumberValue("@.id").isEqualTo(99);

        assertThat(json.write(patient)).hasJsonPathStringValue("@.firstName");
        assertThat(json.write(patient)).
                extractingJsonPathStringValue("@.firstName").isEqualTo("first");

        assertThat(json.write(patient)).hasJsonPathStringValue("@.lastName");
        assertThat(json.write(patient)).
                extractingJsonPathStringValue("@.lastName").isEqualTo("last");

        assertThat(json.write(patient)).hasJsonPathStringValue("@.midName");
        assertThat(json.write(patient)).
                extractingJsonPathStringValue("@.midName").isEqualTo("midname");

        assertThat(json.write(patient)).hasJsonPathNumberValue("@.age");
        assertThat(json.write(patient)).extractingJsonPathNumberValue("@.age").isEqualTo(10);

    }

    @Test
    public void patientDeserializationTest() throws IOException {

        String expected = """
           {
               "id":99,
               "firstName": "name",
               "lastName" : "last",
               "midName" : "midname",
               "age":12
           }
           """;
        assertThat(json.parse(expected))
                .isEqualTo(new Patient(99L, "name", "last", "midname", 12));
        assertThat(json.parseObject(expected).id()).isEqualTo(99);
        assertThat(json.parseObject(expected).firstName()).isEqualTo("name");
        assertThat(json.parseObject(expected).lastName()).isEqualTo("last");
        assertThat(json.parseObject(expected).midName()).isEqualTo("midname");
        assertThat(json.parseObject(expected).age()).isEqualTo(12);
    }
}
