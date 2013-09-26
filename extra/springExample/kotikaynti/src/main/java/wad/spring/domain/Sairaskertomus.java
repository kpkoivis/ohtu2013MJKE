/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author kristian.koivisto
 */
@Entity
public class Sairaskertomus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    @ManyToOne
    private AjanvarausAika ajanvaraus;
    @Column(length=10000)
    private String kayntiTeksti;

    public AjanvarausAika getAjanvaraus() {
        return ajanvaraus;
    }

    public void setAjanvaraus(AjanvarausAika ajanvaraus) {
        this.ajanvaraus = ajanvaraus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKayntiTeksti() {
        return kayntiTeksti;
    }

    public void setKayntiTeksti(String kayntiTeksti) {
        this.kayntiTeksti = kayntiTeksti;
    }    
}
