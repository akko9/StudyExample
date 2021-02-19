package utils;

public enum CountryEnum {
    one(1,"韩"),two(2,"赵"),three(3,"魏"),four(4,"楚"),five(5,"燕"),six(6,"齐");

    private Integer code;
    private String countryName;

    CountryEnum(Integer code, String countryName) {
        this.code = code;
        this.countryName = countryName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public static String GetCountryName(Integer code){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum country:values) {
            if (code.equals(country.getCode())){
                return country.getCountryName();
            }
        }
        return null;
    }

}
