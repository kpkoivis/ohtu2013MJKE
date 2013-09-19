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
import wad.spring.domain.Laakari;
import wad.spring.service.LaakariService;

@Controller
public class LaakariController {

    @Autowired
    private LaakariService laakariService;

    /*
    @RequestMapping(value = "/laakari")
    public String add(@ModelAttribute Laakari laakari) {
        laakariService.create(laakari);
        return "redirect:/home";
    }

    */
    
    @RequestMapping(value = "/lisaalaakari", method = RequestMethod.GET)
    public String lisaaLaakariGET(Model model) {
        model.addAttribute("laakari", new Laakari());

        return "laakari/lisaalaakari";
    }

    @RequestMapping(value = "/lisaalaakari", method = RequestMethod.POST)
    public String lisaaLaakariPOST(@Valid @ModelAttribute("laakari") Laakari laakari, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("laakari", laakari);
            return "laakari/lisaalaakari";
        }
        List<Laakari> laakarit = laakariService.list();
        for (Laakari l : laakarit) {
            if (l.getTunnus().equals(laakari.getTunnus())) {
                return "laakari/lisaalaakari_unsuccessful_tunnus_isalready";
            }
        }
        laakariService.create(laakari);
        model.addAttribute("laakari", laakari);
        return "laakari/lisaalaakari_successful";
    }

    @RequestMapping(value = "/listaalaakarit", method = RequestMethod.GET)
    public String listaaLaakarit(Model model) {
        model.addAttribute("laakarit", laakariService.list());
        return "laakari/listaalaakarit";
    }


}
