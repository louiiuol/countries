package dev.louiiuol.countries.api.controllers.dtos.requests;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryFromApiDto {

    @NotNull
    @JsonProperty("alpha2Code")
    private String code;

    @NotNull
    private String nativeName;

    @NotNull
    private String region;

    @NotNull
    private String flag;

    public CountryFromApiDto() {   }

	public String getCode() {
		return code.toLowerCase();
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

	@Override
	public int hashCode() {
		return Objects.hash(code, nativeName, region, flag);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if ( !(obj instanceof CountryFromApiDto) )
			return false;
		return Objects.equals(this.code, ( (CountryFromApiDto) obj ).code);
	}

}
