package ma.enset.patientsmvcziani;

import ma.enset.patientsmvcziani.entities.Patient;
import ma.enset.patientsmvcziani.repositories.PatientRepository;
import ma.enset.patientsmvcziani.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsmvcZianiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsmvcZianiApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //@Bean//cette méthode s'éxécute au démarrage
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args ->{
            patientRepository.save(
                    new Patient(null,"Hassan",new Date(),false,120));
            patientRepository.save(
                    new Patient(null,"Mohamed",new Date(),true,321));
            patientRepository.save(
                    new Patient(null,"Yassmine",new Date(),true,165));
            patientRepository.save(
                    new Patient(null,"Hanae",new Date(),false,230));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("mohamed","1234","1234");
            securityService.saveNewUser("yasmine","1234","1234");
            securityService.saveNewUser("hassan","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("mohamed","USER");
            securityService.addRoleToUser("mohamed","ADMIN");
            securityService.addRoleToUser("yasmine","USER");
            securityService.addRoleToUser("hassan","USER");
        };
    }


}
