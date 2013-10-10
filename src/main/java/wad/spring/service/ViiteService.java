package wad.spring.service;

import java.util.List;
import wad.spring.domain.Viite;

public interface ViiteService {
    Viite findOne(Long id);
    Viite create(Viite viite);
    List<Viite> list();
    public String listAllBiBTeX();
    public List<Viite> mockList();
    public void delete(Long viiteId);

    public boolean exists(Long viiteId);
}
