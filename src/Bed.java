public class Bed {
    private int bedNumber;
    private String bedType;
    private String bedSpecialEquipment;
    private boolean isOccupied;

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

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "bedNumber=" + bedNumber +
                ", bedType='" + bedType + '\'' +
                ", bedSpecialEquipment='" + bedSpecialEquipment + '\'' +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
