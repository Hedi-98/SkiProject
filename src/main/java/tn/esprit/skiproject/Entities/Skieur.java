package tn.esprit.skiproject.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Skieur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;
    @ManyToMany(mappedBy = "skieurs")
    private Set<Piste> pistes;
    @OneToMany(mappedBy = "skieur")
    private Set<Inscription> inscriptions;
    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;
}
