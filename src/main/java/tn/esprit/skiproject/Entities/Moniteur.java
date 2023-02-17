package tn.esprit.skiproject.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Moniteur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    @Temporal(TemporalType.DATE)
    private Date dateRecru;
    @OneToMany()
    private Set<Cours> cours;
}
