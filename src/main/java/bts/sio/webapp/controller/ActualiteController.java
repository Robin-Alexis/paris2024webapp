package bts.sio.webapp.controller;

import bts.sio.webapp.model.Actualite;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.model.Sport;
import bts.sio.webapp.service.ActualiteService;
import bts.sio.webapp.service.EpreuveService;
import bts.sio.webapp.service.SportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Data
@Controller
public class ActualiteController {


    @Autowired
    private ActualiteService actualiteService;

    @Autowired
    private SportService sportService;

    @Autowired
    private EpreuveService epreuveService;


    @GetMapping("/actualites")
    public String home(Model model) {
        Iterable<Actualite> listActualites = actualiteService.getActualites();

        model.addAttribute("actualites", listActualites);
        return "actualite/listerActualite";    }

    @GetMapping("/consulterActualite/{id}")
    public String consulterActualite(@PathVariable("id") final int id, Model model) {
        Actualite a = actualiteService.getActualite(id);
        model.addAttribute("actualite", a);

        return "actualite/consulterActualite";
    }

    @GetMapping("/actualite/createActualite")
    public String createActualite(Model model) {
        Actualite a = new Actualite();
        model.addAttribute("actualite", a);

        Iterable<Sport> listSport = sportService.getLesSports();
        model.addAttribute("listSport", listSport);

        Iterable<Epreuve> listEpreuve = epreuveService.getLesEpreuves();
        model.addAttribute("listEpreuve", listEpreuve);


        return "actualite/formNewActualite";
    }

    @PostMapping("/actualite/saveActualite")
    public ModelAndView saveActualite(@ModelAttribute Actualite actualite) {
        System.out.println("controller save=" + actualite.getTitre());
        actualiteService.saveActualite(actualite);
        return new ModelAndView("redirect:/actualites");
    }

    @GetMapping("/actualite/updateActualite/{id}")
    public String updateActualite(@PathVariable("id") final int id, Model model) {
        Actualite a = actualiteService.getActualite(id);
        model.addAttribute("actualite", a);

        model.addAttribute("listSport", sportService.getLesSports());
        model.addAttribute("listEpreuve", epreuveService.getLesEpreuves());

        return "actualite/formUpdateActualite";
    }
}