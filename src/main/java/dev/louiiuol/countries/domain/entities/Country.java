package dev.louiiuol.countries.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false, length = 3)
    private String code; 

    @Column(nullable = false, length = 100)
    private String nativeName;

    @Column(nullable = false, length = 100)
    private String region;

    @Column(nullable = false)
    private String flag;

    public Country() {    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Country(String code, String nativeName, String region, String flag) {
        this.code = code;
        this.nativeName = nativeName;
        this.region = region;
        this.flag = flag;
    }

}
