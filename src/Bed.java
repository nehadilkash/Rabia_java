public class Bed {
    private int bedNumber;
    private String bedType;
    private String bedSpecialEquipment;

    public Bed(int bedNumber, String bedType, String bedSpecialEquipment) {
        this.bedNumber = bedNumber;
        this.bedType = bedType;
        this.bedSpecialEquipment = bedSpecialEquipment;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getBedSpecialEquipment() {
        return bedSpecialEquipment;
    }

    public void setBedSpecialEquipment(String bedSpecialEquipment) {
        this.bedSpecialEquipment = bedSpecialEquipment;
    }

}
