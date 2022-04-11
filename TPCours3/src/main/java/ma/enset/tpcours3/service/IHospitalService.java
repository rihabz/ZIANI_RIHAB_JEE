package ma.enset.tpcours3.service;

import ma.enset.tpcours3.entities.Consultation;
import ma.enset.tpcours3.entities.Medcin;
import ma.enset.tpcours3.entities.Patient;
import ma.enset.tpcours3.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medcin saveMedcin(Medcin medcin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
