package bts.sio.webapp.model;

import lombok.Data;

@Data
public class Investissement {

    private Integer id;
    private Double montant;
    private Sport sport;
    private Entreprise entreprise;
}
