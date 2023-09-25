package tn.esprit.skiproject.Services;

import tn.esprit.skiproject.Entities.Abonnement;
import tn.esprit.skiproject.Entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    List<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
