package ma.enset.tpcours3.repositories;

import ma.enset.tpcours3.entities.Medcin;
import ma.enset.tpcours3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository <Medcin,Long>{
    Medcin findByNom(String nom);
}
