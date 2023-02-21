package tn.esprit.skiproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.skiproject.Entities.Piste;
import tn.esprit.skiproject.Repositories.PisteRepository;

import java.util.List;

@Service
public class PisteService implements IPisteService {
    @Autowired
    PisteRepository pisteRepo;
    @Override
    public List<Piste> retrieveAllPistes() {
        return (List<Piste>) pisteRepo.findAll();
    }

    @Override
    public Piste addOrUpdatePiste(Piste piste) {
        return pisteRepo.save(piste);
    }

    @Override
    public void removePiste(Piste piste) {
        pisteRepo.delete(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepo.findById(numPiste).get();
    }
}
