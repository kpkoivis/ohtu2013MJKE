package wad.spring.controller;

import java.util.ArrayList;
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
import wad.spring.domain.Aika;
import wad.spring.domain.AjanvarausAika;
import wad.spring.domain.Asiakas;
import wad.spring.domain.Laakari;
import wad.spring.service.AjanvarausaikaService;
import wad.spring.service.AsiakasService;
import wad.spring.service.LaakariService;

@Controller
public class AikaController {

    @Autowired
    private AsiakasService asiakasService;
    @Autowired
    private LaakariService laakariService;
    @Autowired
    private AjanvarausaikaService aikaService;
    

    
    @RequestMapping(value = "/lisaaaika", method = RequestMethod.GET)
    public String lisaaAikaGET(Model model) {
        List<Laakari> laakarit = laakariService.list();
        if (laakarit.isEmpty()) {
            return "aika/lisaaaika/lisaaaika_ei_laakareita";
        }
        model.addAttribute("aika", new Aika());
        model.addAttribute("laakarit", laakarit);
        return "aika/lisaaaika/lisaaaika";
    }

    @RequestMapping(value = "/lisaaaika", method = RequestMethod.POST)
    public String lisaaAikaPOST(@Valid @ModelAttribute("aika") Aika aika, BindingResult result, @RequestParam Long laakariId, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("aika", aika);
            model.addAttribute("laakarit", laakariService.list());
            return "aika/lisaaaika/lisaaaika";
        }
        if (!aika.isValid()) {
            return "aika/lisaaaika/aika_vaaranlainen";
        }
        
        Laakari laakari = laakariService.findOne(laakariId);
        AjanvarausAika ajanvarausaika = new AjanvarausAika(aika, laakari);
        ajanvarausaika.setVarattu(false);
        laakari.addAjanvarausAika(ajanvarausaika);
        aikaService.create(ajanvarausaika);
        model.addAttribute("ajanvarausaika", ajanvarausaika);
        return "aika/lisaaaika/lisaaaika_successful";
    }
    
    @RequestMapping(value = "/varaaaika", method = RequestMethod.GET)
    public String varaaAikaGET(Model model) {
        List<Asiakas> asiakkaat = asiakasService.listAll();
        if (asiakkaat.isEmpty()) {
            return "aika/varaaaika/varaaaika_ei_asiakkaita";
        }
        List<AjanvarausAika> ajat = aikaService.listVapaat();
        if (ajat.isEmpty()) {
            return "aika/varaaaika/varaaaika_ei_aikoja";
        }
        model.addAttribute("ajat", ajat);
        model.addAttribute("asiakkaat", asiakkaat);
        return "aika/varaaaika/varaaaika";
    }

    @RequestMapping(value = "/varaaaika", method = RequestMethod.POST)
    public String varaaAikaPOST(@RequestParam Long asiakasId, @RequestParam Long aikaId, @RequestParam String syy, Model model) {
        Asiakas asiakas = asiakasService.findOne(asiakasId);
        AjanvarausAika ajanvarausaika = aikaService.findOne(aikaId);
        ajanvarausaika.setVarausSyy(syy);
        ajanvarausaika.setVarattu(Boolean.TRUE);
        ajanvarausaika.setAsiakas(asiakas);
        aikaService.saveOrUpdate(ajanvarausaika);
        model.addAttribute("ajanvarausaika", ajanvarausaika);
        return "aika/varaaaika/varaaaika_successful";
    }
    
    @RequestMapping(value = "/varaaaika_omalaakari", method = RequestMethod.GET)
    public String varaaAikaOmalaakariGET(Model model, @RequestParam Long asiakasId) {
        List<Asiakas> asiakkaat = asiakasService.listAll();
        if (asiakkaat.isEmpty()) {
            return "aika/varaaaika/varaaaika_ei_asiakkaita";
        }
        Asiakas asiakas = asiakasService.findOne(asiakasId);
        List<AjanvarausAika> ajat = aikaService.listVapaatOmalaakari(asiakas);
        if (ajat.isEmpty()) {
            return "aika/varaaaika/varaaaika_ei_aikoja";
        }
        model.addAttribute("ajat", ajat);
        model.addAttribute("asiakkaat", asiakkaat);
        return "aika/varaaaika/varaaaika";
    }    
}