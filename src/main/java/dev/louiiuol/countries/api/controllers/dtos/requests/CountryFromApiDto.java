package dev.louiiuol.countries.api.controllers.dtos.requests;

import javax.validation.constraints.NotNull;

public class CountryFromApiDto {

    private String code;

    @NotNull
    private String alpha2Code;

    @NotNull
    private String nativeName;

    @NotNull
    private String region;

    @NotNull
    private String flag;

    public CountryFromApiDto() {}
    
    public void setCode(String iso) {
        this.code = iso;
    }

    public String getCode() {
        return code;
    }

    public void setAlpha2Code(String iso) {
        this.alpha2Code = iso;
    }

    public String getAlpha2Code() {
        return alpha2Code;
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

    public CountryFromApiDto(String code, String nativeName, String region, String flag) {
        this.code = code;
        this.nativeName = nativeName;
        this.region = region;
        this.flag = flag;
    }
    
}
