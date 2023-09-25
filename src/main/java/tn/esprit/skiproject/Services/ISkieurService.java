package tn.esprit.skiproject.Services;

import tn.esprit.skiproject.Entities.Skieur;
import tn.esprit.skiproject.Entities.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addOrUpdateSkieur(Skieur skieur);
    void removeSkieur (Skieur skieur);
    Skieur retrieveSkieur (Long numSkieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur addSkieurAndAssignToCourse(Skieur skieur,Long numCours);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
