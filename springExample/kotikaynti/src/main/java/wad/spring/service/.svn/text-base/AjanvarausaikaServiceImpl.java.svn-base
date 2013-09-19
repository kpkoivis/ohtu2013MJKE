
package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.AjanvarausAika;
import wad.spring.domain.Asiakas;
import wad.spring.domain.Laakari;
import wad.spring.repository.AjanvarausaikaRepository;
import wad.spring.repository.AsiakasRepository;
import wad.spring.repository.LaakariRepository;

@Service
public class AjanvarausaikaServiceImpl implements AjanvarausaikaService {

    @Autowired
    private AjanvarausaikaRepository aikaRepository;

    @Override
    public void create(AjanvarausAika aika) {
        aikaRepository.save(aika);
    }

    @Override
    public void saveOrUpdate(AjanvarausAika aika) {
        aikaRepository.save(aika);
    }

    @Override
    public List<AjanvarausAika> listAll() {
        return aikaRepository.findAll();
    }

    @Override
    public AjanvarausAika findOne(Long aikaId) {
        return aikaRepository.findOne(aikaId);
    }

    @Override
    public List<AjanvarausAika> listVapaat() {
        List<AjanvarausAika> kaikkiAjat = listAll();
        List<AjanvarausAika> vapaatAjat = new ArrayList<AjanvarausAika>();
        
        for (AjanvarausAika aika : kaikkiAjat) {
            if (aika.getVarattu() == false) {
                vapaatAjat.add(aika);
            }
        }
        return vapaatAjat;
    }
    
    @Override
    public List<AjanvarausAika> listVaratut() {
        List<AjanvarausAika> kaikkiAjat = listAll();
        List<AjanvarausAika> varatutAjat = new ArrayList<AjanvarausAika>();
        
        for (AjanvarausAika aika : kaikkiAjat) {
            if (aika.getVarattu() == true) {
                varatutAjat.add(aika);
            }
        }
        return varatutAjat;
    }

    @Override
    public List<AjanvarausAika> listVapaatOmalaakari(Asiakas asiakas) {
        List<AjanvarausAika> kaikkiAjat = listAll();
        List<AjanvarausAika> vapaatAjat = new ArrayList<AjanvarausAika>();
        
        if (asiakas.getOmalaakari() == null) {
            return vapaatAjat;
        }
        
        for (AjanvarausAika aika : kaikkiAjat) {
            if (aika.getVarattu() == false) {
                if (aika.getLaakari().getId() == asiakas.getOmalaakari().getId()) {
                    vapaatAjat.add(aika);
                }
            }
        }
        return vapaatAjat;
    }
}
