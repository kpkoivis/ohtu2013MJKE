package wad.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Asiakas implements Serializable {

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
    @NotNull(message = "Osoite on annettava.")
    @Size(min = 8, max = 40, message = "Osoitteen pituuden pitää olla 8-40 merkkiä.")
    @Pattern(regexp = "^[a-zåäöA-ZÅÄÖ1234567890, \\-]+$", message = "Osoiteessa on merkkejä, mitkä eivät ole sallittuja")
    private String osoite;
    @ManyToOne //(cascade = {CascadeType.ALL})
    private Laakari omalaakari;
    @OneToMany(mappedBy = "asiakas", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<AjanvarausAika> ajanvarausAjat;

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    
    
    public List<AjanvarausAika> getAjanvarausAjat() {
        return ajanvarausAjat;
    }

    public void setAjanvarausAjat(List<AjanvarausAika> ajanvarausAjat) {
        this.ajanvarausAjat = ajanvarausAjat;
    }

    
    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }


    public void setOmalaakari(Laakari omalaakari) {
        this.omalaakari = omalaakari;
    }

    public Laakari getOmalaakari() {
        return omalaakari;
    }
}
