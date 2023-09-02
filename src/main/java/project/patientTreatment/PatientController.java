package project.patientTreatment;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<Patient> findById(@PathVariable Long requestedId) {
        Optional<Patient> patientOptional = patientRepository.findById(requestedId);

        if(patientOptional.isPresent()){

            return ResponseEntity.ok(patientOptional.get());
        } else{
            return ResponseEntity.notFound().build();
        }


    }
}
