package wad.spring.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.spring.domain.Viite;
import wad.spring.service.ViiteService;

@Controller
public class ViiteController {

    @Autowired
    private ViiteService viiteService;
    
    @RequestMapping(value = "/lisaalaakari", method = RequestMethod.GET)
    public String lisaaLaakariGET(Model model) {
        model.addAttribute("laakari", new Viite());

        return "laakari/lisaalaakari";
    }

    @RequestMapping(value = "/lisaaviite", method = RequestMethod.POST)
    public String lisaaLaakariPOST(@Valid @ModelAttribute("viite") Viite viite, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("viite", viite);
            // Mitä tehdään virhetilanteessa?
            //return "viite/lisaaviite";
            return "";
        }
        // Onko viite jo?
        List<Viite> viitteet = viiteService.list();
        for (Viite l : viitteet) {
//            if (l.getTunnus().equals(viite.getTunnus())) {
//                // Mitä tehdään jos viite on jo?
//                // return "viite/lisaaviite_unsuccessful_tunnus_isalready";
//                return "";
//            }
        }
        viiteService.create(viite);
        model.addAttribute("viite", viite);
        // Mitä tehdään jos ok?
        // return "viite/lisaaviite_successful";
        return "";
    }

    @RequestMapping(value = "/listaaviitteet", method = RequestMethod.GET)
    public String listaaViitteet(Model model) {
        model.addAttribute("viitteet", viiteService.list());
        return "viite/listaaviitteet";
    }


}
