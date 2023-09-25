package tn.esprit.skiproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skiproject.Entities.Skieur;
import tn.esprit.skiproject.Entities.TypeAbonnement;
import tn.esprit.skiproject.Services.ISkieurService;

import java.util.List;

@RestController
@RequestMapping("/Skieur")
public class SkieurController {
    @Autowired
    ISkieurService skieurSer;
    @GetMapping("/List")
    public List<Skieur> SkieurList(){
        return skieurSer.retrieveAllSkieurs();
    }
    @PostMapping("/add")
    public Skieur addSkieur(@RequestBody Skieur skieur){
        return skieurSer.addOrUpdateSkieur(skieur);
    }
    @PutMapping("/edit")
    public Skieur editSkieur(@RequestBody Skieur skieur){
        return skieurSer.addOrUpdateSkieur(skieur);
    }
    @GetMapping("/{numSkieur}")
    public Skieur searchSkieur(@PathVariable Long numSkieur){
        return skieurSer.retrieveSkieur(numSkieur);
    }
    @DeleteMapping("/delete")
    public void delSkieur(@RequestBody Skieur skieur){
        skieurSer.removeSkieur(skieur);
    }

    @PutMapping ("/{numSkieur}/{numPiste}")
    public Skieur affSkieur(@PathVariable Long numSkieur,@PathVariable Long numPiste){
        return skieurSer.assignSkierToPiste(numSkieur,numPiste);
    }

    @PutMapping ("/affClasse/{numCours}")
    public Skieur affSkieur(@RequestBody Skieur skieur,@PathVariable("numCours") Long numCours){
        return skieurSer.addSkieurAndAssignToCourse(skieur,numCours);
    }

    @GetMapping ("/{type}")
    public List<Skieur> affSkieur(@RequestBody Skieur skieur, @PathVariable("type") TypeAbonnement type){
        return skieurSer.retrieveSkiersBySubscriptionType(type);
    }

}
