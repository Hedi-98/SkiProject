package tn.esprit.skiproject.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
@Entity
/* @Data Getter/Setter/Required_Args/Equals&HashCode/ToString */
/* @RequiredArgsConstructor add @NonNull to selected attributes */
/* @FieldDefaults(level = AccessLevel.PRIVATE) */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Abonnement {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numAbon;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private Float prixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;
}
