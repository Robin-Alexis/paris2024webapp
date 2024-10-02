package bts.sio.webapp.service;

import bts.sio.webapp.model.Actualite;
import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.repository.ActualiteProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ActualiteService {

    @Autowired
    private ActualiteProxy actualiteProxy;

    public Iterable<Actualite> getActualites() {
        return actualiteProxy.getActualites();
    }

    public Actualite getActualite(final int id) {
        return actualiteProxy.getActualite(id);
    }

    public Actualite saveActualite(Actualite actualite) {
        Actualite savedActualite;

        if(actualite.getId() == null) {
            // If id is null, then it is a new employee.
            savedActualite = actualiteProxy.createActualite(actualite);
        } else {
            savedActualite = actualiteProxy.updateActualite(actualite);
        }

        return savedActualite;
    }

}
