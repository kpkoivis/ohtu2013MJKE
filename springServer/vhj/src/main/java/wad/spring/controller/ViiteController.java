package wad.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.spring.domain.Viite;
import wad.spring.service.ViiteService;

@Controller
public class ViiteController {

    @Autowired
    private ViiteService viiteService;
          
    @RequestMapping(value = "/lisaaviite.do", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Viite lisaaViite(@RequestBody Viite viite) {
 
        // Pitäisi tarkistaa onko viite jo olemassa..

        viiteService.create(viite);
        return viite;
    }

    @RequestMapping(value = "/listaaviitteet.do", method = RequestMethod.GET)
    public @ResponseBody List<Viite> listaaViitteet(Model model) {
        List<Viite> viiteLista = viiteService.list();
        return viiteLista;
    }
    
    
    @RequestMapping(value = "/test.listaaviitteet.do", method = RequestMethod.GET)
    public @ResponseBody List<Viite> testListaaViitteet(Model model) {
        List<Viite> viiteLista = viiteService.testList();
        return viiteLista;
    }
}
