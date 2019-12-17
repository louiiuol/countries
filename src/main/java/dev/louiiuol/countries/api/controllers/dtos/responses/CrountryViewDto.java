package dev.louiiuol.countries.api.controllers.dtos.responses;

public class CrountryViewDto {

    private String code;

    private String nativeName;

    private String region;

    private String flag;

    public CrountryViewDto() {
    }

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

    public CrountryViewDto(String code, String nativeName, String region, String flag) {
        this.code = code;
        this.nativeName = nativeName;
        this.region = region;
        this.flag = flag;
    }
    
}
