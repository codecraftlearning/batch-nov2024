package models;

public class ElectronicDevice {
    private Long consumption;
    private Long voltage;
    private Long amp;

    ElectronicDevice(Long consumption, Long voltage, Long amp) {
        super();
        this.setConsumption(consumption);
        this.setAmp(amp);
        this.setVoltage(voltage);
    }

    public Long getConsumption() {
        return consumption;
    }

    public void setConsumption(Long consumption) {
        this.consumption = consumption;
    }

    public Long getVoltage() {
        return voltage;
    }

    public void setVoltage(Long voltage) {
        this.voltage = voltage;
    }

    public Long getAmp() {
        return amp;
    }

    public void setAmp(Long amp) {
        this.amp = amp;
    }

//    @Override
//    public String toString() {
//        return "ElectronicDevice{" +
//                "consumption=" + consumption +
//                ", voltage=" + voltage +
//                ", amp=" + amp +
//                '}';
//    }
}
