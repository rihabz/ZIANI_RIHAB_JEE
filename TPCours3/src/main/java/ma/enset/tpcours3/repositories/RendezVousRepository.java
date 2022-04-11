package ma.enset.tpcours3.repositories;

import ma.enset.tpcours3.entities.Patient;
import ma.enset.tpcours3.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository <RendezVous,String>{
}
