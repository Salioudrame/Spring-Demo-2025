package sn.esmt.demo2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.esmt.demo2025.domain.Vehicule;
import sn.esmt.demo2025.domain.Voiture;
import sn.esmt.demo2025.services.VehiculeService;

import java.util.List;

@Controller
public class VehiculeController {
    @Autowired
    @Qualifier("laVoiture")
    Voiture voiture;

    @Autowired
    VehiculeService voitureService;
//    @RequestMapping( value = "/", method = RequestMethod.GET)
    @RequestMapping(value = "/user/{user}")
//    @GetMapping("/")
    public String getHome(@PathVariable("user") String username, @RequestParam String classe, Model model) {
        // Traitements
        model.addAttribute("message","Bienvenue "+ username+" dans la classe "+classe);
        model.addAttribute("voiture",voiture);
        // Appel de la vue
        return "home";
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        // Traitements
        model.addAttribute("message","Bienvenue dans la classe !");
        model.addAttribute("voiture",voiture);
        // Appel de la vue
        return "home";
    }

    @PostMapping("/add")
    public String addVoiture(@ModelAttribute Voiture voiture2, Model model) {
        try {
            voitureService.addVehicule(voiture2);
            model.addAttribute("message", "Voiture ajoutée !");
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Erreur: " + e.getMessage());
        }
        model.addAttribute("voiture", voiture2);
        return "home";
    }



    @GetMapping("/cars")
    public String getAllCars(Model model) {
        List<Vehicule> allVehicules = voitureService.getAllVehicules();
        model.addAttribute("cars", allVehicules);
        return "cars";
    }

    @GetMapping("/voitures/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Vehicule voiture = voitureService.getVehiculeById(id);
        if (voiture == null) {
            return "redirect:/cars";  // Redirection si la voiture n'existe pas
        }
        model.addAttribute("voiture", voiture);
        return "deletecar";
    }

//    @GetMapping("/voitures/delete/{id}")
//    public String showDeleteForm(@PathVariable Long id, Model model) {
//        model.addAttribute("voiture", voitureService.getVehiculeById(id));
//        return "deletecar";
//    }

    @PostMapping("/voitures/delete/{id}")
    public String deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVehicule(voitureService.getVehiculeById(id));
        return "redirect:/cars";
    }
}
