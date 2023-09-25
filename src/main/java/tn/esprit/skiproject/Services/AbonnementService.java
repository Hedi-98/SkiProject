package tn.esprit.skiproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skiproject.Entities.Abonnement;
import tn.esprit.skiproject.Entities.TypeAbonnement;
import tn.esprit.skiproject.Repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AbonnementService implements IAbonnementService {
    @Autowired
    AbonnementRepository abonnementRepo;
    @Override
    public List<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return abonnementRepo.getSubscriptionByTypeAbonOrderByDateDebut(type);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepo.retrieveSubscriptionsByDates(startDate, endDate);
    }
}
