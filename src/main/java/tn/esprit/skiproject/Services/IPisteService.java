package tn.esprit.skiproject.Services;

import tn.esprit.skiproject.Entities.Piste;

import java.util.List;

public interface IPisteService {
    List<Piste> retrieveAllPistes();
    Piste addOrUpdatePiste(Piste piste);
    void removePiste (Piste piste);
    Piste retrievePiste (Long numPiste);
}
