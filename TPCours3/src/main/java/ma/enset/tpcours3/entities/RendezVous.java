package ma.enset.tpcours3.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.net.SocketFlow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class RendezVous {
    @Id
    private String id;
    private Date date;
    @Enumerated(EnumType.STRING)//POUR QUE LE STATUT SERA STOCK2 EN BDD en tant que string non pas 0 1 2
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //POUR éviter le problème des dépendances cycliques lors de l'affichage
    //il ne va pas retourner le patient dans la partie web
    private Patient patient;
    @ManyToOne
    private Medcin medcin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
