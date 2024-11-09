package interfaces;

public interface IStudent {
    public Integer getRoll();
    public Integer getClassNumber();
    public Integer getRank();
    public String getGender();
    public default String getPetName() {
        return ""+getClassNumber();
    }
}
