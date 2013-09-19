package wad.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.spring.domain.AjanvarausAika;
import wad.spring.domain.Asiakas;
import wad.spring.domain.Sairaskertomus;
import wad.spring.service.AjanvarausaikaService;
import wad.spring.service.AsiakasService;
import wad.spring.service.SairaskertomusService;

@Controller
public class SairaskertomusController {

    @Autowired
    private SairaskertomusService kertomusService;
    @Autowired
    private AjanvarausaikaService aikaService;
    @Autowired
    private AsiakasService asiakasService;

    
    @RequestMapping(value = "/kirjaasairaskertomus", method = RequestMethod.GET)
    public String kirjaaSairaskertomusGET(Model model) {
        List<AjanvarausAika> ajat = aikaService.listVaratut();
        if (ajat.isEmpty()) {
            return "sairaskertomus/kirjaa/kirjaa_ei_varattuja_aikoja";
        }
        model.addAttribute("ajanvarausajat", ajat);
        return "sairaskertomus/kirjaa/valitseajanvaraus";
    }

    @RequestMapping(value = "/kirjaasairaskertomus", method = RequestMethod.POST)
    public String kirjaaSairaskertomusPOST(@RequestParam Long aikaId, Model model) {
        AjanvarausAika aika = aikaService.findOne(aikaId);
        model.addAttribute("ajanvaraus", aika);
        return "sairaskertomus/kirjaa/kirjaussivu";
    }

    @RequestMapping(value = "/kirjaa", method = RequestMethod.POST)
    public String kirjaaPOST(@RequestParam Long aikaID, @RequestParam String kertomusteksti, Model model) {
        AjanvarausAika aika = aikaService.findOne(aikaID);
        Sairaskertomus kertomus = new Sairaskertomus();
        kertomus.setAjanvaraus(aika);
        kertomus.setKayntiTeksti(kertomusteksti);
        kertomusService.saveOrUpdate(kertomus);
        model.addAttribute("kertomus", kertomus);
        return "sairaskertomus/kirjaa/kirjaa_successful";
    }
    
    @RequestMapping(value = "/katsosairaskertomus", method = RequestMethod.GET)
    public String katsoSairaskertomusGET(Model model) {
        List<Asiakas> asiakkaat = asiakasService.listAll();
        if (asiakkaat.isEmpty()) {
            return "sairaskertomus/katsele/ei_asiakkaita";
        }
        model.addAttribute("asiakkaat", asiakkaat);
        return "sairaskertomus/katsele/valitseasiakas";
    }
    
    @RequestMapping(value = "/sairaskertomus_katsele_asiakkaan", method = RequestMethod.GET)
    public String katsoSairaskertomusAsiakkaanGET(@RequestParam Long asiakasId, Model model) {
        List<Sairaskertomus> sairaskertomus = kertomusService.list(asiakasId);
        model.addAttribute("sairaskertomus", sairaskertomus);
        Asiakas asiakas = asiakasService.findOne(asiakasId);
        model.addAttribute("asiakas", asiakas);
        return "sairaskertomus/katsele/nayta_asiakkaan_kertomus";
    }
    
    
    
    
}
