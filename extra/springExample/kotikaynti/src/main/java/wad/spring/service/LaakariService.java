package wad.spring.service;

import java.util.List;
import wad.spring.domain.Laakari;

public interface LaakariService {
    Laakari findOne(Long id);
    void create(Laakari laakari);
    List<Laakari> list();
}
