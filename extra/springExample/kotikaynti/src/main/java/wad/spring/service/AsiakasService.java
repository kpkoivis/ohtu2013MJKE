
package wad.spring.service;

import java.util.List;
import wad.spring.domain.Asiakas;

public interface AsiakasService {
    void create(Asiakas asiakas);
    public void saveOrUpdate(Asiakas player, Long laakariId);
    public List<Asiakas> listAll();
    public Asiakas findOne(Long asiakasId);
}
