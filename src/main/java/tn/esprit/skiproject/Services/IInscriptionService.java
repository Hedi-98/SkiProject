package tn.esprit.skiproject.Services;

import tn.esprit.skiproject.Entities.Inscription;

public interface IInscriptionService {
    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
}
