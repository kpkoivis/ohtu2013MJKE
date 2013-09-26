package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Laakari;
import wad.spring.repository.LaakariRepository;

@Service
public class LaakariServiceImpl implements LaakariService {

    @Autowired
    LaakariRepository laakariRepository;

    @Override
    @Transactional
    public void create(Laakari laakari) {
        laakariRepository.save(laakari);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Laakari> list() {
        return laakariRepository.findAll();
    }

    @Override
    public Laakari findOne(Long id) {
        return laakariRepository.findOne(id);
    }
}
