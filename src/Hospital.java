import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private List<Room> rooms = new ArrayList<>();
    private String hospitalName;
    private String hospitalAddress;

    public Hospital(String hospitalName, String hospitalAddress) {
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addAllRoom(List<Room> rooms) {
        rooms.addAll(rooms);
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
