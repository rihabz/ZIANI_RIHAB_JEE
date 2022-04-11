package ma.enset.tpcours3.repositories;

import ma.enset.tpcours3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient,Long>{
    Patient findByNom(String name);
}
