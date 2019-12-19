package dev.louiiuol.countries.api.controllers.dtos.requests;

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

    @JsonProperty("alpha2Code")
    public void setCode(String iso) {
        this.code = iso;
    }

    @JsonProperty("alpha2Code")
    public String getCode() {
        return code.toLowerCase();
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

}
