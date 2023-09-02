package project.patientTreatment;


import org.springframework.data.annotation.Id;

public record Patient(@Id Long id, String firstName, String lastName, String midName, Integer age) {
}
