/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Viite implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long                    id;
    private String                  referenceId;
    private String                  referenceType;
    private ArrayList<ViiteItem>    items = new ArrayList<ViiteItem>();
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public List<ViiteItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ViiteItem> items) {
        this.items = items;
    }

    public boolean addItem(ViiteItem item) {
        return this.items.add(item);
    }
    
    public boolean removeItem(ViiteItem item) {
        return this.items.remove(item);
    }
    
    public boolean addItem(String fieldName, String fieldValue) {
        ViiteItem vi = new ViiteItem();
        vi.setFieldName(fieldName);
        vi.setFieldValue(fieldValue);
        return this.addItem(vi);
    }
    public boolean removeItem(String fieldName) {
        for (ViiteItem item : this.items) {
            if (item.getFieldName().compareTo(fieldName) == 0) {
                return removeItem(item);
            }
        }
        return false;
    }

    public String getItemValueWithFieldName(String fieldName) {
        for (ViiteItem item : this.items) {
            if (item.getFieldName().compareTo(fieldName) == 0) {
                return item.getFieldValue();
            }
        }
        return null;
    }
 
    public String toStringBiBTex() {
        String bibtex = "@" + this.referenceType + "{";
        bibtex += bibtexCharReplace(this.referenceId) + ",\n";
        for (ViiteItem item : this.items) {
            bibtex += item.getFieldName() + " = {" + bibtexCharReplace(item.getFieldValue()) + "},\n";
        }
        bibtex += "}\n";
        return bibtex;
    }

    private String bibtexCharReplace(String s) {
        s = s.replace("ä", "\\" + "\"" + "{a}");
        s = s.replace("ö", "\\" + "\"" + "{o}");
        s = s.replace("Ä", "\\" + "\"" + "{A}");
        s = s.replace("Ö", "\\" + "\"" + "{O}");
        s = s.replace("å", "\\" + "aa");
        s = s.replace("Å", "\\" + "AA");
        return s;
    }
}
