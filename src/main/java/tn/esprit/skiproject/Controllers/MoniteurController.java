package tn.esprit.skiproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skiproject.Entities.Moniteur;
import tn.esprit.skiproject.Services.IMoniteurService;

import java.util.List;
@RestController
@RequestMapping("/Moniteur")
public class MoniteurController {
    @Autowired
    IMoniteurService moniteurSer;
    @GetMapping("/List")
    public List<Moniteur> MoniteurList(){
        return moniteurSer.retrieveAllMoniteurs();
    }
    @PostMapping("/add")
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur){
        return moniteurSer.addOrUpdateMoniteur(moniteur);
    }
    @PutMapping("/edit")
    public Moniteur editMoniteur(@RequestBody Moniteur moniteur){
        return moniteurSer.addOrUpdateMoniteur(moniteur);
    }
    @GetMapping("/{numMoniteur}")
    public Moniteur searchMoniteur(@PathVariable Long numMoniteur){
        return moniteurSer.retrieveMoniteur(numMoniteur);
    }
    @DeleteMapping("/delete")
    public void delMoniteur(@RequestBody Moniteur moniteur){
        moniteurSer.removeMoniteur(moniteur);
    }
}
