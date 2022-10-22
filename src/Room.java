public class Room {
    private int roomNumber;
    private int floor;
    private String roomSpeciality;
    private String roomVisitationHours;
    private Bed[] beds;

    public Room(int roomNumber, int floor, String roomSpeciality, String roomVisitationHours, Bed[] beds) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomSpeciality = roomSpeciality;
        this.roomVisitationHours = roomVisitationHours;
        this.beds = beds;
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

    public Bed[] getBeds() {
        return beds;
    }

    public void setBeds(Bed[] beds) {
        this.beds = beds;
    }
}
