package project.patientTreatment;

import org.springframework.data.repository.CrudRepository;

public interface DiseaseRepository extends CrudRepository<Disease,Long> {
    
}
