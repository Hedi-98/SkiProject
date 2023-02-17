package tn.esprit.skiproject.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cours {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numCours;
    private int niveau;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;
    @Enumerated(EnumType.STRING)
    private  Support support;
    private Float prix;
    private int creneau;
    @OneToMany(mappedBy = "cours")
    private Set<Inscription> inscriptions;
}
