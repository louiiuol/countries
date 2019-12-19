package dev.louiiuol.countries.api.controllers.dtos.responses;

import java.util.Objects;

public class CountryViewDto {

    private String code;

    private String nativeName;

    private String region;

    private String flag;

    public String getCode() { return code; }

    public String getNativeName() { return nativeName; }

    public String getRegion() { return region; }

    public String getFlag() { return flag; }

    public CountryViewDto() { /** Default empty Constructor */ } 

    @Override
	public int hashCode() { return Objects.hash(code, nativeName, region, flag); }

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof CountryViewDto) )
			return false;
		return code.equals( ( (CountryViewDto) obj ).code );
    }
}
