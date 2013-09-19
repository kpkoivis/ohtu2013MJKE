/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author kristiak
 */
@Entity
public class AjanvarausAika implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idajanvarausaika") 
    private Long idajanvarausaika;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date aloitusAika;
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    //private Date lopetusAika;
    private String kesto;
    @ManyToOne
    private Laakari laakari;
    @ManyToOne
    private Asiakas asiakas;
    private String varausSyy;
    private Boolean varattu;
    
    
    public Boolean getVarattu() {
        return varattu;
    }

    public void setVarattu(Boolean varattu) {
        this.varattu = varattu;
    }


    public Long getIdajanvarausaika() {
        return idajanvarausaika;
    }

    public void setIdajanvarausaika(Long idajanvarausaika) {
        this.idajanvarausaika = idajanvarausaika;
    }

    public AjanvarausAika() {
    }

    public AjanvarausAika(Aika aika, Laakari laakari) {
        this.laakari = laakari;
        
        DateFormat df = new SimpleDateFormat("dd MM yyyy kk mm");
        try {
            aloitusAika = df.parse(aika.getPaiva() + " " +
                                 aika.getKuukausi() + " " +
                                 aika.getVuosi() + " " +
                                 aika.getTunti() + " " +
                                 aika.getMinuutti());
            kesto = aika.getKesto();
        } catch (ParseException ex) {
            Logger.getLogger(AjanvarausAika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public String getVarausSyy() {
        return varausSyy;
    }

    public void setVarausSyy(String varausSyy) {
        this.varausSyy = varausSyy;
    }
    
    

    public Date getAloitusAika() {
        return aloitusAika;
    }

    public void setAloitusAika(Date aloitusAika) {
        this.aloitusAika = aloitusAika;
    }

    public Asiakas getAsiakas() {
        return asiakas;
    }

    public void setAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public Laakari getLaakari() {
        return laakari;
    }

    public void setLaakari(Laakari laakari) {
        this.laakari = laakari;
    }
/*
    public Date getLopetusAika() {
        return lopetusAika;
    }

    public void setLopetusAika(Date lopetusAika) {
        this.lopetusAika = lopetusAika;
    }
*/

    public String getKesto() {
        return kesto;
    }

    public void setKesto(String kesto) {
        this.kesto = kesto;
    }

    
}
