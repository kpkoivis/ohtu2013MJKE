package wad.spring.service;

import java.util.List;
import wad.spring.domain.Viite;

public interface ViiteService {
    Viite findOne(Long id);
    void create(Viite viite);
    List<Viite> list();

    public List<Viite> testList();
}
