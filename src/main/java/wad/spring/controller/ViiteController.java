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
        // Pitäisi tarkistaa onko viite jo olemassa..luotetaan toistaiseksi frontendiin
        return viiteService.create(viite);
    }

    
    @RequestMapping(value = "/poistaviite.do", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Viite poistaViite(@RequestBody Viite viite) {
        Long id = viite.getId();

        if (viiteService.exists(id)) {
            viiteService.delete(id);
            viite.setId(-1L);
            return viite;
        }
        // return viite as is if it wasn't in the database
        return viite;
    }


    @RequestMapping(value = "/listaaviite.do", method = RequestMethod.GET)
    @ResponseBody
    public Viite listaaViite(@RequestParam("id") Long id) {
      System.out.println(id);

      Viite viite = viiteService.findOne(id);
      System.out.println(viite);
      System.out.println(viiteService.exists(id));
      return viite;
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
    
    @RequestMapping(value = "/test2.listaaviitteet.do", method = RequestMethod.GET)
    public @ResponseBody int test2ListaaViitteet() {
        //List<Viite> viiteLista = viiteService.mockList();
        //return viiteLista;
        int Id = 1;
        return Id;
    }
}
