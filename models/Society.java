package models;

public class Society {
    private Long id;
    private String parentName;
    private String petName;
    private String country;
    private String state;
    private String city;
    private String street;
    private String block;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        //pincode = fetchpincode (this.city) -> number; this.city += " ("+pincode+")"
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setName(String parent, String pet) {
        this.parentName = parent;
        this.petName = pet;
    }

    public String getName() {
        return parentName + petName;
    }

    public String getAddress() {
        return this.getName()+", "+this.getBlock()+", "+this.getStreet()+", "+this.getCity()+", "+this.getState()+", "+getCountry();
    }
}
