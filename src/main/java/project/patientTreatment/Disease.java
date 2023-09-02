package project.patientTreatment;

import org.springframework.data.annotation.Id;

public record Disease(@Id Long id, String code, String descr) {
}
