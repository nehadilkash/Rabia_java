import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ParseException {
        Hospital hospital = createHospital();
        Scanner scanner = new Scanner(System.in);
        char terminate = 'y';
        while (terminate == 'y') {
            Patient patient = createPatientRecord();
            assignBed(hospital, patient);
            System.out.println(patient+" has been assigned to "+patient.getBed() +" bed");
            System.out.println("to enter next patient record press 'y'");
            terminate = scanner.nextLine().charAt(0);
        }
    }

    public static void assignBed(Hospital hospital, Patient patient) {
        for (Room room : hospital.getRooms()) {
            for (Bed bed : room.getBeds()) {
                if (!bed.isOccupied()) {
                    patient.setBed(bed);
                    bed.setOccupied(true);
                    break;
                }
            }
            if (patient.getBed() != null)
                break;
        }
    }

    public static Patient createPatientRecord() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter patient Details");
        System.out.println("Name : ");
        String name = scanner.nextLine();

        System.out.println("Dob (dd-MM-yyyy)  : ");
        String dob = scanner.nextLine();
        Date convertedDob = covertStringToDate(dob);

        System.out.println("Date Admitted (dd-MM-yyyy)  : ");
        String dateAdmitted = scanner.nextLine();
        Date convertedDateAdmitted = covertStringToDate(dateAdmitted);

        System.out.println("Diagnosis  : ");
        String diagnosis = scanner.nextLine();

        return new Patient(name, convertedDob, convertedDateAdmitted, diagnosis);
    }

    public static Date covertStringToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }

    public static Hospital createHospital() {
        Bed bed011 = new Bed(1, "manual", "Bed Rails");
        Bed bed012 = new Bed(2, "electric", " OverBed Table");
        Room room01 = new Room(1, 0, "Delivery room", "7-9", new Bed[]{bed011, bed012});

        Bed bed021 = new Bed(2, "electric", " none");
        Room room02 = new Room(2, 0, "Consulting room", "7-9", new Bed[]{bed021});


        Bed bed031 = new Bed(1, "semi-electric", "Bed Rails");
        Bed bed032 = new Bed(2, "electric", " OverBed Table");
        Room room03 = new Room(3, 0, "Ward", "7-9", new Bed[]{bed031, bed032});


        Bed bed041 = new Bed(1, "manual", "OverBed Table");
        Bed bed042 = new Bed(2, "electric", "Bed Rails");
        Room room04 = new Room(4, 0, "Maternity Ward", "7-9", new Bed[]{bed041, bed042});


        Bed bed051 = new Bed(1, "manual", "Bed Rails");
        Bed bed052 = new Bed(2, "electric", " OverBed Table");
        Room room05 = new Room(5, 0, "Nursery", "7-9", new Bed[]{bed051, bed052});

        Bed bed061 = new Bed(1, "manual", "Bed Rails");
        Bed bed062 = new Bed(2, "electric", " OverBed Table");
        Room room06 = new Room(6, 0, "Day Care", "7-9", new Bed[]{bed061, bed062});


        Bed bed111 = new Bed(1, "manual", "Bed Rails");
        Bed bed112 = new Bed(2, "electric", " OverBed Table");
        Room room11 = new Room(1, 0, "ICU", "7-9", new Bed[]{bed111, bed112});


        Bed bed121 = new Bed(2, "electric", " none");
        Room room12 = new Room(2, 0, "operating theater", "7-9", new Bed[]{bed121});

        Bed bed131 = new Bed(1, "semi-electric", "Bed Rails");
        Bed bed132 = new Bed(2, "electric", " OverBed Table");
        Room room13 = new Room(3, 0, "Private ward", "7-9", new Bed[]{bed131, bed132});

        Bed bed141 = new Bed(1, "manual", "OverBed Table");
        Bed bed142 = new Bed(2, "electric", "Bed Rails");
        Room room14 = new Room(4, 0, "Private Ward", "7-9", new Bed[]{bed141, bed142});

        Bed bed151 = new Bed(1, "manual", "Bed Rails");
        Bed bed152 = new Bed(2, "electric", " OverBed Table");
        Room room15 = new Room(5, 0, "Emergency room", "7-9", new Bed[]{bed151, bed152});

        Hospital hospital = new Hospital(new Room[]{room01, room02, room03, room04, room05, room06, room11, room12, room13, room14, room15},
                "Northside", "any address");
        return hospital;
    }
}
