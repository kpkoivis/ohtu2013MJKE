package wad.spring.service;

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
}