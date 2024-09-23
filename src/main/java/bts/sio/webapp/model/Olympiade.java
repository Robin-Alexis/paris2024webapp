package bts.sio.webapp.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class Olympiade {

    private Integer id;
    private String numero;
    private Integer annee;
    private String ville;
    private Pays pays;
    private ArrayList<Athlete> athletes = new ArrayList<>();


}
