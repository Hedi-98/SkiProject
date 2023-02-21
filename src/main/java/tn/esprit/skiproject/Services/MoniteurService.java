package tn.esprit.skiproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skiproject.Entities.Moniteur;
import tn.esprit.skiproject.Repositories.MoniteurRepository;

import java.util.List;

@Service
public class MoniteurService implements IMoniteurService {
    @Autowired
    MoniteurRepository moniteurRepo;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return (List<Moniteur>) moniteurRepo.findAll();
    }

    @Override
    public Moniteur addOrUpdateMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public void removeMoniteur(Moniteur moniteur) {
        moniteurRepo.delete(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepo.findById(numMoniteur).get();
    }
}
