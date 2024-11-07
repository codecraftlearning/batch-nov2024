package models;

public class Laptop {

    private String company;
    private String model;
    private Double price;

    Laptop(String company, String model, Double price) {
//        super(5L, 2L, 1L);
        super();
        this.setCompany(company);
        this.setModel(model);
        this.setPrice(price);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
