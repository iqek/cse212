public class Provider {
    private String name;
    private int countryCode;
    private int areaCode;
    private int phoneNumber;

    
    Provider(String name, int countryCode, int areaCode, int phoneNumber){
        this.name = name;
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCountryCode(int countryCode){
        this.countryCode = countryCode;
    }

    public void setAreaCode(int areaCode){
        this.areaCode = areaCode;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }


    public String getName(){
        return name;
    }

    public int getCountryCode(){
        return countryCode;
    }

    public int getAreaCode(){
        return areaCode;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    } 
}
