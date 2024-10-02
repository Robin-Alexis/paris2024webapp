package bts.sio.webapp.service;

import bts.sio.webapp.model.Actualite;
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


}
