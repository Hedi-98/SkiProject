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
public class Piste {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numPiste;
    private String nomPiste;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int longueur;
    private int pente;
    @ManyToMany
    private Set<Skieur> skieurs;
}
