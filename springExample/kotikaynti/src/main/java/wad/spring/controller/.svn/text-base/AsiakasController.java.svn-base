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
import org.springframework.web.bind.annotation.RequestParam;
import wad.spring.domain.Asiakas;
import wad.spring.domain.Laakari;
import wad.spring.service.AsiakasService;
import wad.spring.service.LaakariService;

@Controller
public class AsiakasController {

    @Autowired
    private AsiakasService asiakasService;
    @Autowired
    private LaakariService laakariService;

    
    @RequestMapping(value = "/lisaaasiakas", method = RequestMethod.GET)
    public String lisaaAsiakasGET(Model model) {
        model.addAttribute("asiakas", new Asiakas());
        model.addAttribute("laakarit", laakariService.list());
        return "asiakas/lisaaasiakas";
    }

    @RequestMapping(value = "/lisaaasiakas", method = RequestMethod.POST)
    public String lisaaAsiakasPOST(@Valid @ModelAttribute("asiakas") Asiakas asiakas, BindingResult result, @RequestParam Long laakariId, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("asiakas", asiakas);
            model.addAttribute("laakarit", laakariService.list());
            return "asiakas/lisaaasiakas";
        }
        
        List<Asiakas> asiakkaat = asiakasService.listAll();
        for (Asiakas a : asiakkaat) {
            if (a.getTunnus().equals(asiakas.getTunnus())) {
                return "asiakas/lisaaasiakas_unsuccessful_tunnus_isalready";
            }
        }
        if (laakariId != 0) {
            Laakari laakari = laakariService.findOne(laakariId);
            asiakas.setOmalaakari(laakari);
        }
        asiakasService.create(asiakas);
        model.addAttribute("asiakas", asiakas);
        return "asiakas/lisaaasiakas_successful";
    }
    
    @RequestMapping(value = "/listaaasiakkaat", method = RequestMethod.GET)
    public String listaaAsiakkaat(Model model) {
        model.addAttribute("asiakkaat", asiakasService.listAll());
        return "asiakas/listaaasiakkaat";
    }

}