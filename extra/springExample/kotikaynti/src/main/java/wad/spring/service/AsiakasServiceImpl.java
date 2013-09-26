package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Asiakas;
import wad.spring.domain.Laakari;
import wad.spring.repository.AsiakasRepository;
import wad.spring.repository.LaakariRepository;

@Service
public class AsiakasServiceImpl implements AsiakasService {

    @Autowired
    private AsiakasRepository asiakasRepository;
    @Autowired
    private LaakariRepository laakariRepository;

    @Override
    @Transactional
    public void create(Asiakas asiakas) {
        asiakasRepository.save(asiakas);
    }
    
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Asiakas> listAll() {
        return asiakasRepository.findAll();
    }
    
    @Override
    @Transactional
    public void saveOrUpdate(Asiakas asiakas, Long laakariId) {
        Laakari t = laakariRepository.findOne(laakariId);
        t.addOmaasiakas(asiakas);
        laakariRepository.save(t);
    }

    @Override
    public Asiakas findOne(Long asiakasId) {
        return asiakasRepository.findOne(asiakasId);
    }


}
