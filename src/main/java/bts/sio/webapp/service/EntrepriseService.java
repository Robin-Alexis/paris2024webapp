package bts.sio.webapp.service;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Entreprise;
import bts.sio.webapp.repository.EntrepriseProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EntrepriseService {


    @Autowired
    private EntrepriseProxy entrepriseProxy;

    public Iterable<Entreprise> getEntreprises() {
        return entrepriseProxy.getEntreprises();
    }

    public Entreprise saveEntreprise(Entreprise entreprise) {
        Entreprise savedEntreprise;

        // Functional rule : Last name must be capitalized.

        if(entreprise.getId() == null) {
            // If id is null, then it is a new employee.
            savedEntreprise = entrepriseProxy.createEntreprise(entreprise);
        } else {
            savedEntreprise = entrepriseProxy.updateEntreprise(entreprise);
        }

        return savedEntreprise;
    }
}
