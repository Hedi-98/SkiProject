package tn.esprit.skiproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skiproject.Entities.Piste;
import tn.esprit.skiproject.Services.IPisteService;

import java.util.List;

@RestController
@RequestMapping("/Piste")
public class PisteController {
    @Autowired
    IPisteService pisteSer;
    @GetMapping("/List")
    public List<Piste> PisteList() {
        return pisteSer.retrieveAllPistes();
    }
    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteSer.addOrUpdatePiste(piste);
    }
    @PutMapping("/edit")
    public Piste editPiste(@RequestBody Piste piste) {
        return pisteSer.addOrUpdatePiste(piste);
    }
    @GetMapping("/{numPiste}")
    public Piste searchPiste(@PathVariable Long numPiste) {
        return pisteSer.retrievePiste(numPiste);
    }
    @DeleteMapping("/delete")
    public void delPiste(@RequestBody Piste piste) {
        pisteSer.removePiste(piste);
    }
}
