package wad.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.spring.domain.Viite;
import wad.spring.service.ViiteService;

import javax.servlet.http.HttpServletResponse;

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
    public @ResponseBody List<Viite> listaaViitteet() {
        List<Viite> viiteLista = viiteService.list();
        return viiteLista;
    }

    @RequestMapping(value = "/lataaBibtext.do", method = RequestMethod.GET, headers = "Accept=application/json")
    public void genereoiBibText(HttpServletResponse res) {
      try {
        String tiedostonNimi = "testBibText.txt";
        URL url = getClass().getResource("/" + tiedostonNimi);
        File f = new File(url.toURI());
        if (f.exists()) {
          res.setContentLength(new Long(f.length()).intValue());
          res.setHeader("Content-Disposition", "attachment; filename=\"" + tiedostonNimi + "\"");
          FileCopyUtils.copy(new FileInputStream(f), res.getOutputStream());
        } else {
          System.out.println("Tiedostoa " + tiedostonNimi + "(" + f.getAbsolutePath() + ") ei löydy");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    
    @RequestMapping(value = "/listaaviitteetBiBTeX.do", method = RequestMethod.GET, produces="text/plain" )
    @ResponseBody
    public String listaaViitteetBiBTex() {
        String bibtex = viiteService.listAllBiBTeX();
        return bibtex;
    }
}
