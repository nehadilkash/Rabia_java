import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private int floor;
    private String roomSpeciality;
    private String roomVisitationHours;
    private List<Bed> beds=new ArrayList<>();

    public Room(int roomNumber, int floor, String roomSpeciality, String roomVisitationHours) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomSpeciality = roomSpeciality;
        this.roomVisitationHours = roomVisitationHours;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRoomSpeciality() {
        return roomSpeciality;
    }

    public void setRoomSpeciality(String roomSpeciality) {
        this.roomSpeciality = roomSpeciality;
    }

    public String getRoomVisitationHours() {
        return roomVisitationHours;
    }

    public void setRoomVisitationHours(String roomVisitationHours) {
        this.roomVisitationHours = roomVisitationHours;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void addBed(Bed bed) {
        beds.add(bed);
    }

    public void addAllBed(List<Bed> beds) {
        beds.addAll(beds);
    }
}
