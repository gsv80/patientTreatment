package project.patientTreatment.db;

import org.springframework.data.repository.CrudRepository;

import project.patientTreatment.Disease;

public interface DiseaseRepository extends CrudRepository<Disease,Long> {
    
}
