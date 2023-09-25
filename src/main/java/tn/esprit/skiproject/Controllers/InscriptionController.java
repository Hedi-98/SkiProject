package tn.esprit.skiproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skiproject.Entities.Abonnement;
import tn.esprit.skiproject.Entities.Inscription;
import tn.esprit.skiproject.Entities.TypeAbonnement;
import tn.esprit.skiproject.Services.IInscriptionService;

import java.util.List;

@RestController
@RequestMapping("/Inscription")
public class InscriptionController {
    @Autowired
    IInscriptionService inscriptionSer;
    @PostMapping("/add/{skier}/{cours}")
    public Inscription SubsListType(@RequestBody Inscription inscription, @PathVariable("skier") Long numSkieur, @PathVariable("cours") Long numCours){
        return inscriptionSer.addRegistrationAndAssignToSkierAndCourse(inscription,numSkieur,numCours);
    }
}
