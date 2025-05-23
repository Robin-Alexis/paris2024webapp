package bts.sio.webapp.service;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Categorie;
import bts.sio.webapp.repository.AthleteProxy;
import bts.sio.webapp.repository.CategorieProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CategorieService {

    @Autowired
    private CategorieProxy categorieProxy;

    public Iterable<Categorie> getCategories() {
        return categorieProxy.getCategories();
    }

}
