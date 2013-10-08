package wad.spring.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Viite;
import wad.spring.domain.ViiteItem;
import wad.spring.repository.ViiteRepository;

@Service
public class ViiteServiceImpl implements ViiteService {

    @Autowired
    ViiteRepository viiteRepository;

    @Override
    @Transactional
    public void create(Viite viite) {
        viiteRepository.save(viite);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Viite> list() {
        return viiteRepository.findAll();
    }

    @Override
    public Viite findOne(Long id) {
        return viiteRepository.findOne(id);
    }

    
    @Override
    @Transactional
    public void delete(Long id) {
        viiteRepository.delete(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean exists(Long id) {
        return viiteRepository.exists(id);
    }
    
    @Override
    public String listAllBiBTeX() {
        String bibtex = "";
        List<Viite> viitteet = this.list();
        for (Viite v : viitteet) {
            bibtex += v.toStringBiBTex() + "\n";
        }
        return bibtex;
    }

    @Override
    public List<Viite> mockList() {
        List<Viite> list = new ArrayList<Viite>();
       
        Viite viite1 = new Viite();
        viite1.setId(1L);
        viite1.setViiteType("book");
        viite1.setReferenceId("HS01");
        viite1.setItems(new ArrayList<ViiteItem>());
        viite1.addItem("author/editor","Hawking, Stephen");
        viite1.addItem("title", "A Brief History of Time");
        viite1.addItem("publisher","Bantam Dell Publishing Group");
        viite1.addItem("year", "1988");
        list.add(viite1);
        
        Viite viite2 = new Viite();
        viite2.setId(2L);
        viite2.setViiteType("inproceedings");
        viite2.setReferenceId("KSEP");
        viite2.setItems(new ArrayList<ViiteItem>());
        viite2.addItem("author","Kääriäinen, Seppo");
        viite2.addItem("title", "Kepulaisuuden ähkyt ökyrikkaat");
        viite2.addItem("booktitle","Ääliöt ja Örkit");
        viite2.addItem("year", "2013");
        list.add(viite2);
        
        Viite viite3 = new Viite();
        viite3.setId(3L);
        viite3.setViiteType("article");
        viite3.setReferenceId("FEYR");
        viite3.setItems(new ArrayList<ViiteItem>());
        viite3.addItem("author","Feynman, Richard");
        viite3.addItem("title", "Quantum Physics for Dummies");
        viite3.addItem("journal","The Dummy things for Dummies");
        viite3.addItem("year", "2991");
        list.add(viite3);

        Viite viite4 = new Viite();
        viite4.setId(4L);
        viite4.setViiteType("misc");
        viite4.setReferenceId("DFJ1");
        viite4.setItems(new ArrayList<ViiteItem>());
        viite4.addItem("author","Doesntfit, James");
        viite4.addItem("title", "The misfit's reflection");
        viite4.addItem("howpublished","it was a miracle believe me");
        viite4.addItem("month","oct");
        viite4.addItem("year", "1982");
        viite4.addItem("note","remove this before publication you doughnut!");
        viite4.addItem("key", "forgot mine at home");
        list.add(viite4);
      
        return list;
    }
}
