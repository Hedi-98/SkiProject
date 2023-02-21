package tn.esprit.skiproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skiproject.Entities.Cours;
import tn.esprit.skiproject.Services.ICoursService;

import java.util.List;

@RestController
@RequestMapping("/Cours")
public class CoursController {
    @Autowired
    ICoursService coursSer;
    @GetMapping("/List")
    public List<Cours> CoursList(){
        return coursSer.retrieveAllCourses();
    }
    @PostMapping("/add")
    public Cours addCours(@RequestBody Cours cours){
        return coursSer.addOrUpdateCours(cours);
    }
    @PutMapping("/edit")
    public Cours editCours(@RequestBody Cours cours){
        return coursSer.addOrUpdateCours(cours);
    }
    @GetMapping("/{numCours}")
    public Cours searchCours(@PathVariable Long numCours){
        return coursSer.retrieveCours(numCours);
    }
    @DeleteMapping("/delete")
    public void delCours(@RequestBody Cours cours){
        coursSer.removeCours(cours);
    }
}
