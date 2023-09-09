package project.patientTreatment.db;


import org.springframework.data.repository.CrudRepository;

import project.patientTreatment.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
