package tn.esprit.skiproject.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inscription {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long numInscription;
    private int numSemaine;
    @ManyToOne
    private Skieur skieur;
    @ManyToOne
    private Cours cours;
}
