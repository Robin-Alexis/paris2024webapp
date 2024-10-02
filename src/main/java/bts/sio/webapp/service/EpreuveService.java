package bts.sio.webapp.service;

import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.repository.EpreuveProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EpreuveService {

    @Autowired
    private EpreuveProxy epreuveProxy;

    public Epreuve getEpreuve(final int id) {
        return epreuveProxy.getEpreuve(id);
    }

    public Iterable<Epreuve> getLesEpreuves() {
        return epreuveProxy.getLesEpreuves();
    }

    public void deleteEpreuve(final int id) {
        epreuveProxy.deleteEpreuve(id);
    }

    public Epreuve saveEpreuve(Epreuve epreuve) {
        Epreuve savedEpreuve;


        if (epreuve.getId() == null) {
            savedEpreuve = epreuveProxy.createEpreuve(epreuve);
        } else {
            savedEpreuve = epreuveProxy.updateEpreuve(epreuve);
        }

        return savedEpreuve;
    }

}
