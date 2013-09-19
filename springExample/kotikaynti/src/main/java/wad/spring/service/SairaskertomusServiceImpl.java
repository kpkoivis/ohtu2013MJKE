/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.spring.domain.Sairaskertomus;
import wad.spring.repository.SairaskertomusRepository;

/**
 *
 * @author kristian.koivisto
 */
@Service
public class SairaskertomusServiceImpl implements SairaskertomusService {
    @Autowired
    private SairaskertomusRepository sairaskertomusRepository;
    
    @Override
    public Sairaskertomus findOne(Long id) {
        return sairaskertomusRepository.findOne(id);
    }

    @Override
    public void create(Sairaskertomus kertomus) {
        sairaskertomusRepository.save(kertomus);
    }

    @Override
    public List<Sairaskertomus> list() {
        return sairaskertomusRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Sairaskertomus kertomus) {
        sairaskertomusRepository.save(kertomus);
    }

    @Override
    public List<Sairaskertomus> list(Long asiakasId) {
        List<Sairaskertomus> kertomusKoko = sairaskertomusRepository.findAll();
        List<Sairaskertomus> kertomusAsiakas = new ArrayList<Sairaskertomus>();
        for (Sairaskertomus sk : kertomusKoko) {
            if (sk.getAjanvaraus().getAsiakas().getId() == asiakasId) {
                kertomusAsiakas.add(sk);
            }
        }
        return kertomusAsiakas;
    }
    
}
