package ma.enset.tpcours3;

import ma.enset.tpcours3.entities.*;
import ma.enset.tpcours3.repositories.ConsultationRepository;
import ma.enset.tpcours3.repositories.MedcinRepository;
import ma.enset.tpcours3.repositories.PatientRepository;
import ma.enset.tpcours3.repositories.RendezVousRepository;
import ma.enset.tpcours3.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class TpCours3Application {

    public static void main(String[] args) {
        SpringApplication.run(TpCours3Application.class, args);
    }
    @Bean//methode qui va s'éxecuter au démarrage et il va retourner un objet qui va devenir un composant spring
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository,RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository,MedcinRepository medcinRepository){
        return args -> {
            Stream.of("Mohammed","Hassan","Najat")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                       hospitalService.savePatient(patient);
                    });
            Stream.of("Aymane","hanane","yassmine")
                    .forEach(name->{
                        Medcin medcin=new Medcin();
                        medcin.setNom(name);
                        medcin.setEmail(name+"@gmail.com");
                        medcin.setSpecialite(Math.random()>0.5?"cardio":"Dentiste");
                       hospitalService.saveMedcin(medcin);
                    });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1= patientRepository.findByNom("Mohamed");

            Medcin medcin=medcinRepository.findByNom("yassmine");
            //Créer un rendez vous
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedcin(medcin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV=hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            //RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation ....");
            hospitalService.saveConsultation(consultation);
        };


    }
    /*CommandLineRunner start(PatientRepository patientRepository,
                            MedcinRepository medcinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("Mohammed","Hassan","Najat")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    });
            Stream.of("Aymane","hanane","yassmine")
                    .forEach(name->{
                        Medcin medcin=new Medcin();
                        medcin.setNom(name);
                        medcin.setEmail(name+"@gmail.com");
                        medcin.setSpecialite(Math.random()>0.5?"cardio":"Dentiste");
                        medcinRepository.save(medcin);
                    });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1= patientRepository.findByNom("Mohamed");

            Medcin medcin=medcinRepository.findByNom("yassmine");
            //Créer un rendez vous
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedcin(medcin);
            rendezVous.setPatient(patient);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation ....");
            consultationRepository.save(consultation);
        };

    }*/
}
