/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Laakari implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Tunnus on annettava.")
    @Size(min = 6, max = 10, message = "Tunnuksen pituuden pitää olla 6-10 merkkiä.")
    @Pattern(regexp = "\\w+", message = "Tunnuksen pitää koostua pelkästään kirjaimista tai numeroista tai niiden yhdistelmistä.")
    private String tunnus;
    @NotNull(message = "Etunimi on annettava.")
    @Size(min = 2, max = 40, message = "Etunimen pituuden pitää olla 2-40 merkkiä.")
    @Pattern(regexp = "^[a-zåäöA-ZÅÄÖ \\-]+$", message = "Etunimen pitää koostua kirjaimista.")
    private String etunimi;
    @NotNull(message = "Sukunimi on annettava.")
    @Size(min = 2, max = 40, message = "Sukunimen pituuden pitää olla 2-40 merkkiä.")
    @Pattern(regexp = "^[a-zåäöA-ZÅÄÖ \\-]+$", message = "Sukunimen pitää koostua kirjaimista.")
    private String sukunimi;
    @NotNull(message = "Sv-numero on annettava.")
    @Size(min = 6, max = 6, message = "Sv-numerosarjassa pitää olla tasan kuusi numeroa.")
    @Pattern(regexp = "\\d+", message = "Sv-numerosarjassa saa olla pelkästään numeroita")
    private String svnumero;
    @OneToMany(mappedBy = "omalaakari", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Asiakas> omaasiakkaat;
    @OneToMany(mappedBy = "laakari") //, cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<AjanvarausAika> ajanvarausAjat;

    public List<AjanvarausAika> getAjanvarausAjat() {
        return ajanvarausAjat;
    }

    public void setAjanvarausAjat(List<AjanvarausAika> ajanvarausAjat) {
        this.ajanvarausAjat = ajanvarausAjat;
    }
    
    public void addAjanvarausAika(AjanvarausAika aika) {
        this.ajanvarausAjat.add(aika);
    }

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }
    
    public void addOmaasiakas(Asiakas asiakas) {
        if(!omaasiakkaat.contains(asiakas)) {
            omaasiakkaat.add(asiakas);
        }
        
        asiakas.setOmalaakari(this);
    }

    public List<Asiakas> getOmaasiakkaat() {
        return omaasiakkaat;
    }

    public void setOmaasiakkaat(List<Asiakas> asiakkaat) {
        this.omaasiakkaat = asiakkaat;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getSvnumero() {
        return svnumero;
    }

    public void setSvnumero(String svnumero) {
        this.svnumero = svnumero;
    }
    
    
    
    

    @Override
    public String toString() {
        return this.etunimi;
    }
}
