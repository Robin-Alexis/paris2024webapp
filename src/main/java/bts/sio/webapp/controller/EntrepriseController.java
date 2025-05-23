package bts.sio.webapp.controller;

import bts.sio.webapp.model.*;
import bts.sio.webapp.service.CategorieService;
import bts.sio.webapp.service.EntrepriseService;
import bts.sio.webapp.service.SportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class EntrepriseController {
    @Autowired
    private EntrepriseService entrepriseService;

    @Autowired
    private CategorieService categorieService;


    @GetMapping("/entreprises")
    public String home(Model model) {
        Iterable<Entreprise> listEntreprises = entrepriseService.getEntreprises();

        model.addAttribute("entreprises", listEntreprises);
        return "entreprise/listerEntreprise";
    }

    @GetMapping("/entreprise/createEntreprise")
    public String createEntreprise(Model model) {
        Entreprise e = new Entreprise();
        model.addAttribute("entreprise", e);

        Iterable<Categorie> listCategorie = categorieService.getCategories();
        model.addAttribute("listCategorie", listCategorie);

        return "entreprise/formNewEntreprise";
    }


    @PostMapping("/entreprise/saveEntreprise")
    public ModelAndView saveEntreprise(@ModelAttribute Entreprise entreprise) {
        entrepriseService.saveEntreprise(entreprise);
        return new ModelAndView("redirect:/entreprises");
    }

}
