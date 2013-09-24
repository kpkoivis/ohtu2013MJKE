package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Viite;
import wad.spring.repository.ViiteRepository;

@Service
public class ViiteServiceImpl implements ViiteService {

    @Autowired
    ViiteRepository viiteRepository;

    @Override
    @Transactional
    public void create(Viite laakari) {
        viiteRepository.save(laakari);
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
    public List<Viite> testList() {
        Viite viite1 = new Viite();
        Viite viite2 = new Viite();
        Viite viite3 = new Viite();
        List<Viite> viiteLista = new ArrayList<Viite>();
        
        viite1.setId(0L);
        viite1.setAuthor("King, Stephen");
        viite1.setBookTitle("The Shining");
        viite1.setTitle("Chapter 1");
        viite1.setItemYear("1977");
        
        viite2.setId(1L);
        viite2.setAuthor("Vihavainen, Arto");
        viite2.setBookTitle("Webpalvelinohjelmointi");
        viite2.setTitle("joku osa");
        viite2.setItemYear("2013");
         
        viite3.setId(2L);
        viite3.setAuthor("Ankka, Aku");
        viite3.setBookTitle("Elämäni epäonnistumiset");
        viite3.setTitle("Lapsuuteni");
        viite3.setItemYear("2001");
        
        viiteLista.add(viite3);
        viiteLista.add(viite2);
        viiteLista.add(viite1);
        
        return viiteLista;
    }
    
}
