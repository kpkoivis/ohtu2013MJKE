/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author kris
 */
public class Aika {
    @NotNull(message = "Päivä puuttuu")
    @Size(min = 1, max = 2, message = "Päivän pitää olla 1-31")
    @Pattern(regexp = "\\d+", message = "Päivässä saa olla pelkästään numeroita")
    private String paiva;
    @NotNull(message = "Kuukausi puuttuu")
    @Size(min = 1, max = 2, message = "Kuukauden pitää olla 1-12")
    @Pattern(regexp = "\\d+", message = "Kuukaudessa saa olla pelkästään numeroita")
    private String kuukausi;
    @NotNull(message = "Vuosi puuttuu")
    @Size(min = 4, max = 4, message = "Vuosi pitää antaa tyyliin '2012'")
    @Pattern(regexp = "\\d+", message = "Vuodessa saa olla pelkästään numeroita")
    private String vuosi;
    @NotNull(message = "Tunnit puuttuvat")
    @Size(min = 1, max = 2, message = "Tunnin pitää olla 0-23")
    @Pattern(regexp = "\\d+", message = "Tunnissa saa olla pelkästään numeroita")
    private String tunti;
    @NotNull(message = "Minuutit puuttuvat")
    @Size(min = 1, max = 2, message = "Minuuttien pitää olla 0-59")
    @Pattern(regexp = "\\d+", message = "Minuutissa saa olla pelkästään numeroita")
    private String minuutti;
    @NotNull(message = "Kesto puuttuu")
    @Size(min = 1, max = 2, message = "Kesto annetaan minuuteissa (max 99")
    @Pattern(regexp = "\\d+", message = "Kesto annetaan minuuteissa")
    private String kesto;

    public boolean isValid() {
        int paivaInt = Integer.parseInt(paiva);
        int kuukausiInt = Integer.parseInt(kuukausi);
        int vuosiInt = Integer.parseInt(vuosi);
        int tuntiInt = Integer.parseInt(tunti);
        int minuuttiInt = Integer.parseInt(minuutti);
        int kestoInt = Integer.parseInt(kesto);
        
        if (kestoInt < 10 || kestoInt > 99) return false;
        
        if (tuntiInt < 0 || tuntiInt >= 24) return false;
        if (minuuttiInt < 0 || minuuttiInt >= 60) return false;
        if (vuosiInt < 2000) return false;       
        
        if (kuukausiInt < 1 || kuukausiInt > 12) return false;
        if (paivaInt < 1 || paivaInt > 31) return false;
        if (paivaInt > 29 && kuukausiInt == 2) return false;
        if (paivaInt > 30 && (kuukausiInt == 4 || kuukausiInt == 6 || kuukausiInt == 9 || kuukausiInt == 11)) return false;
                
        return true;
    }
    
    
    
    
    public String getKesto() {
        return kesto;
    }

    public void setKesto(String kesto) {
        this.kesto = kesto;
    }

    public String getKuukausi() {
        return kuukausi;
    }

    public void setKuukausi(String kuukausi) {
        this.kuukausi = kuukausi;
    }

    public String getMinuutti() {
        return minuutti;
    }

    public void setMinuutti(String minuutti) {
        this.minuutti = minuutti;
    }

    public String getPaiva() {
        return paiva;
    }

    public void setPaiva(String paiva) {
        this.paiva = paiva;
    }

    public String getTunti() {
        return tunti;
    }

    public void setTunti(String tunti) {
        this.tunti = tunti;
    }

    public String getVuosi() {
        return vuosi;
    }

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
    }


}
