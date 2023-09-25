package tn.esprit.skiproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.skiproject.Entities.Abonnement;
import tn.esprit.skiproject.Entities.Cours;
import tn.esprit.skiproject.Entities.TypeAbonnement;
import tn.esprit.skiproject.Services.IAbonnementService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Abonnement")
public class AbonnementController {
    @Autowired
    IAbonnementService abonnementSer;
    @GetMapping("/{type}")
    public List<Abonnement> SubsListType(@PathVariable TypeAbonnement type){
        return abonnementSer.getSubscriptionByType(type);
    }
    @GetMapping("/{debut}/{fin}")
    public List<Abonnement> SubsListDates(@PathVariable("debut") LocalDate debut, @PathVariable("fin") LocalDate fin){
        return abonnementSer.retrieveSubscriptionsByDates(debut,fin);
    }
}
