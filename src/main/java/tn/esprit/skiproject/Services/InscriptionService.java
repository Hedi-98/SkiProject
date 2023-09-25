package tn.esprit.skiproject.Services;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skiproject.Entities.Cours;
import tn.esprit.skiproject.Entities.Inscription;
import tn.esprit.skiproject.Entities.Skieur;
import tn.esprit.skiproject.Entities.TypeCours;
import tn.esprit.skiproject.Repositories.CoursRepository;
import tn.esprit.skiproject.Repositories.InscriptionRepository;
import tn.esprit.skiproject.Repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashSet;

@Slf4j
@Service
public class InscriptionService implements IInscriptionService{
    @Autowired
    InscriptionRepository inscriptionRepo;
    @Autowired
    SkieurRepository skieurRepo;
    @Autowired
    CoursRepository coursRepo;
    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur=skieurRepo.findById(numSkieur).get();
        Cours cours=coursRepo.findById(numCours).get();
        inscription.setSkieur(skieur);
        inscription.setCours(cours);
        int age= Period.between(skieur.getDateNaissance(), LocalDate.now()).getYears();
        switch (cours.getTypeCours()){
            case COLLECTIF_ADULTE:
                if (age>=18 && cours.getInscriptions().size()<6)
                    return inscriptionRepo.save(inscription);
            case COLLECTIF_ENFANT:
                if (age<18 && cours.getInscriptions().size()<6)
                    return inscriptionRepo.save(inscription);
            default:
                return inscriptionRepo.save(inscription);
        }
    }
}
