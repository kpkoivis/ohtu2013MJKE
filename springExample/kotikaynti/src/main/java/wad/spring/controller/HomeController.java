/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.spring.service.AjanvarausaikaService;
import wad.spring.service.AsiakasService;
import wad.spring.service.LaakariService;

@Controller
public class HomeController {

    @Autowired
    private AsiakasService asiakasService;
    @Autowired
    private LaakariService laakariService;
    @Autowired
    private AjanvarausaikaService aikaService;
    
    @RequestMapping(value = "/home")
    public String home(Model model) {
        //model.addAttribute("asiakkaat", asiakasService.listAll());
        //model.addAttribute("laakarit", laakariService.list());
        //model.addAttribute("ajat", aikaService.listAll());
        return "toimintovalikko";
    }
}
