package ma.enset.activitepratique;

import ma.enset.activitepratique.entities.Etudiant;
import ma.enset.activitepratique.entities.Genre;
import ma.enset.activitepratique.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ActivitePratiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitePratiqueApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){
        return args ->{
            etudiantRepository.save(
                    new Etudiant(null,"Ziani","Rihab","rihab@hotmail.fr",new Date(), Genre.feminin,true));
            etudiantRepository.save(
                    new Etudiant(null,"Salk","Asma","asma@hotmail.fr",new Date(), Genre.feminin,true));
            etudiantRepository.save(
                    new Etudiant(null,"alaoui","Hamza","alaoui@hotmail.fr",new Date(), Genre.masculin,false));
            etudiantRepository.save(
                    new Etudiant(null,"Zaoui","karim","karim@hotmail.fr",new Date(), Genre.masculin,true));
            etudiantRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
}
