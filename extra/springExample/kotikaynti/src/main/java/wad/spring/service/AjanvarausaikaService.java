package wad.spring.service;

import java.util.List;
import wad.spring.domain.AjanvarausAika;
import wad.spring.domain.Asiakas;



public interface AjanvarausaikaService {
    void create(AjanvarausAika aika);
    public void saveOrUpdate(AjanvarausAika aika);
    public List<AjanvarausAika> listAll();

    public AjanvarausAika findOne(Long aikaId);

    public List<AjanvarausAika> listVapaat();
    public List<AjanvarausAika> listVaratut();

    public List<AjanvarausAika> listVapaatOmalaakari(Asiakas asiakas);
}
