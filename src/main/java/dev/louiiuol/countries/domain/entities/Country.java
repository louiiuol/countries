package dev.louiiuol.countries.domain.entities;

import java.util.Objects;

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

    public Country() {  /** Default empty Constructor */   }

    @Override
	public int hashCode() {
		return Objects.hash(code, nativeName, region, flag);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof Country) )
			return false;
		return Objects.equals(this.code, ( (Country) obj ).code);
    }

}
