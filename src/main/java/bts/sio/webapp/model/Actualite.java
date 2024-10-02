package bts.sio.webapp.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Actualite {

    private Integer id;
    private String titre;
    private LocalDate date;
    private String contenu;
    private Sport sport;
    private Epreuve epreuve;
}
