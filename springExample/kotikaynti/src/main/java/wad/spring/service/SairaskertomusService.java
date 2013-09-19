package wad.spring.service;

import java.util.List;
import wad.spring.domain.Sairaskertomus;

public interface SairaskertomusService {
    Sairaskertomus findOne(Long id);
    void create(Sairaskertomus kertomus);
    List<Sairaskertomus> list();
    List<Sairaskertomus> list(Long asiakasId);
    public void saveOrUpdate(Sairaskertomus kertomus);
}
