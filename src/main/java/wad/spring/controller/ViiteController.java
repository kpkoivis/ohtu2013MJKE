package wad.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wad.spring.domain.Viite;
import wad.spring.service.ViiteService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    
    @RequestMapping(value = "/poistaviite.do", method = RequestMethod.POST)
    @ResponseBody
    public Long lisaaViite(@RequestParam("id") Long viiteId) {
        viiteService.delete(viiteId);
        return viiteService.exists(viiteId) ? viiteId : 0;
    }

    
    @RequestMapping(value = "/listaaviitteet.do", method = RequestMethod.GET)
    public @ResponseBody List<Viite> listaaViitteet() {
        List<Viite> viiteLista = viiteService.list();
        return viiteLista;
    }

    
    @RequestMapping(value = "/lataaBibtext.do", method = RequestMethod.GET)
    @ResponseBody
    public String listaaViitteetBiBTex(HttpServletResponse res, @RequestParam("name") String name) {
        String bibtex = viiteService.listAllBiBTeX();
        String tiedostonNimi = name + ".bib";
        res.setContentLength(bibtex.length());
        res.setHeader("Content-Disposition", "attachment; filename=\"" + tiedostonNimi + "\"");
        return bibtex;
    }
    
    
    @RequestMapping(value = "/test.listaaviitteet.do", method = RequestMethod.GET)
    public @ResponseBody List<Viite> testListaaViitteet() {
        List<Viite> viiteLista = viiteService.mockList();
        return viiteLista;
    }
}
