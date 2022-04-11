package ma.enset.tpcours3.repositories;

import ma.enset.tpcours3.entities.Consultation;
import ma.enset.tpcours3.entities.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository <Consultation,Long>{
}
