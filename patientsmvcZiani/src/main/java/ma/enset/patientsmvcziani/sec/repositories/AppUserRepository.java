package ma.enset.patientsmvcziani.sec.repositories;

import ma.enset.patientsmvcziani.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
