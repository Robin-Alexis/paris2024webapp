package bts.sio.webapp.model;


import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class Athlete {

    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate datenaiss ;
    private Pays pays;
    private Sport sport;

    private ArrayList<Olympiade> olympiades = new ArrayList<>();
}
