public class Hospital {

    private Room[] rooms;
    private String hospitalName;
    private String hospitalAddress;

    public Hospital(Room[] rooms, String hospitalName, String hospitalAddress) {
        this.rooms = rooms;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }
}
