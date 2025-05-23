package bts.sio.webapp.model;

import lombok.Data;
import java.util.List;


@Data
public class Entreprise {

    private Integer id;
    private String nom;
    private String activite;
    private Categorie categorie;
    private Entreprise entreprise;

    private List<Investissement> investissements;
}
