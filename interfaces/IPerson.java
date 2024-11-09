package interfaces;

public interface IPerson {
    public String getName();
    public String getGender();
    public Double getHeight();
    public Double getWeight();
    public default Double calculateBMI() {
        Double bmi = 0D;
        if (getGender().equalsIgnoreCase("Male")) {
            bmi = (getHeight() * getWeight()) / 100;
        } else  {
            bmi = (getHeight() * getWeight()) / 110;
        }

        return bmi;
    }

    public default String getPetName() {
        return ""+getName().charAt(0);
    }
}
