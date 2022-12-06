import java.util.ArrayList;
import java.util.List;

public class HospitalManager {

    public static final Hospital hospital = new Hospital("Northside", "any address");

    public static Hospital createHospital() {
        Bed bed111 = new Bed(111, "manual", "Bed Rails");
        Bed bed112 = new Bed(112, "electric", " OverBed Table");
        Room room11 = new Room(11, 1, "Delivery room", "7-9");
        room11.addBed(bed111);
        room11.addBed(bed112);

        Bed bed121 = new Bed(121, "electric", " none");
        Room room12 = new Room(12, 1, "Consulting room", "7-9");
        room12.addBed(bed121);


        Bed bed131 = new Bed(131, "semi-electric", "Bed Rails");
        Bed bed132 = new Bed(132, "electric", " OverBed Table");
        Room room13 = new Room(13, 1, "Ward", "7-9");
        room13.addBed(bed131);
        room13.addBed(bed132);

        Bed bed141 = new Bed(141, "manual", "OverBed Table");
        Bed bed142 = new Bed(142, "electric", "Bed Rails");
        Room room14 = new Room(14, 1, "Maternity Ward", "7-9");
        room14.addBed(bed141);
        room14.addBed(bed142);

        Bed bed151 = new Bed(151, "manual", "Bed Rails");
        Bed bed152 = new Bed(152, "electric", " OverBed Table");
        Room room15 = new Room(15, 1, "Nursery", "7-9");
        room15.addBed(bed151);
        room15.addBed(bed152);


        Bed bed161 = new Bed(161, "manual", "Bed Rails");
        Bed bed162 = new Bed(162, "electric", " OverBed Table");
        Room room16 = new Room(16, 1, "Day Care", "7-9");
        room16.addBed(bed161);
        room16.addBed(bed162);

        Bed bed211 = new Bed(211, "manual", "Bed Rails");
        Bed bed212 = new Bed(212, "electric", " OverBed Table");
        Room room21 = new Room(21, 2, "ICU", "7-9");
        room21.addBed(bed211);
        room21.addBed(bed212);

        Bed bed221 = new Bed(221, "electric", " none");
        Room room22 = new Room(22, 2, "operating theater", "7-9");
        room22.addBed(bed221);

        Bed bed231 = new Bed(231, "semi-electric", "Bed Rails");
        Bed bed232 = new Bed(232, "electric", " OverBed Table");
        Room room23 = new Room(23, 2, "Private ward", "7-9");
        room23.addBed(bed231);
        room23.addBed(bed232);

        Bed bed241 = new Bed(241, "manual", "OverBed Table");
        Bed bed242 = new Bed(242, "electric", "Bed Rails");
        Room room24 = new Room(24, 2, "Private Ward", "7-9");
        room24.addBed(bed241);
        room24.addBed(bed242);

        Bed bed251 = new Bed(251, "manual", "Bed Rails");
        Bed bed252 = new Bed(252, "electric", " OverBed Table");
        Room room25 = new Room(25, 2, "Emergency room", "7-9");
        room25.addBed(bed251);
        room25.addBed(bed252);

        hospital.addRoom(room11);
        hospital.addRoom(room12);
        hospital.addRoom(room13);
        hospital.addRoom(room14);
        hospital.addRoom(room15);
        hospital.addRoom(room16);
        hospital.addRoom(room21);
        hospital.addRoom(room22);
        hospital.addRoom(room23);
        hospital.addRoom(room24);
        hospital.addRoom(room25);

        DoctorManager.joinDoctors();

        return hospital;
    }

    public static void showAvailableBeds() {
        List<Bed> unoccupiedBeds = new ArrayList<>();
        for (Room r : hospital.getRooms()) {
            for (Bed b : r.getBeds()) {
                if (!b.isOccupied()) {
                    unoccupiedBeds.add(b);
                }
            }
        }
        CommonManager.printList(unoccupiedBeds);
    }

    public static void roomOccupancyReport() {
        String report = "RoomNumber           NumberOfPatients\n";
        for (Room r : hospital.getRooms()) {
            report = report + "\t" + r.getRoomNumber();
            int patientCount = 0;
            for (Bed b : r.getBeds()) {
                if (b.isOccupied()) {
                    patientCount++;
                }
            }
            report = report + "\t\t\t\t\t\t" + patientCount + "\n";
        }
        System.out.println(report);
    }
}
