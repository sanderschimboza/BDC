package zw.co.zb.bdcrbz.DTO;

public class AddressDto {
    private String street;
    private String suburb;
    private String city;

    public AddressDto() {
    }

    public AddressDto(String street, String suburb, String city) {
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
