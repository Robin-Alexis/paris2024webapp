package bts.sio.webapp.controller;

import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.model.Sport;
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
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;
    @Autowired
    private SportService sportService;

    @GetMapping("/epreuves")
    public String home(Model model) {
        Iterable<Epreuve> listEpreuves = epreuveService.getLesEpreuves();

        model.addAttribute("epreuves", listEpreuves);
        return "epreuve/listerEpreuve";
    }

    @GetMapping("/epreuve/createEpreuve")
    public String createEpreuve(Model model) {
        Epreuve e = new Epreuve();
        model.addAttribute("epreuve", e);

        Iterable<Sport> listSport = sportService.getLesSports();
        model.addAttribute("listSport", listSport);

        return "epreuve/formNewEpreuve";
    }


    @GetMapping("/epreuve/updateEpreuve/{id}")
    public String updateEpreuve(@PathVariable("id") final int id, Model model) {
        Epreuve e = epreuveService.getEpreuve(id);
        model.addAttribute("epreuve", e);

        model.addAttribute("listSport", sportService.getLesSports());

        return "epreuve/formUpdateEpreuve";
    }

    @GetMapping("/epreuve/deleteEpreuve/{id}")
    public ModelAndView deleteEpreuve(@PathVariable("id") final int id) {
        epreuveService.deleteEpreuve(id);
        return new ModelAndView("redirect:/epreuves");
    }


    @PostMapping("/epreuve/saveEpreuve")
    public ModelAndView saveEpreuve(@ModelAttribute Epreuve epreuve) {
        System.out.println("controller save=" + epreuve.getNom());
        epreuveService.saveEpreuve(epreuve);
        return new ModelAndView("redirect:/epreuves");
    }

}
