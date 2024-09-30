package bts.sio.webapp.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class Epreuve {

    private Integer id;
    private String nom;
    private Sport sport;
    private ArrayList<Athlete> athletes = new ArrayList<>();


}
