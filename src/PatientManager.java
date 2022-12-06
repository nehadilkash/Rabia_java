import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PatientManager {

    static List<Patient> patients = new ArrayList<>();

    public static void admitPatient() {
        Patient patient = null;
        try {
            patient = PatientManager.createPatientRecord();
        } catch (ParseException e) {
            System.err.println("Exception occurred while adding patient " + e.getMessage());
        }
        PatientManager.assignBed(HospitalManager.hospital, patient);
        System.out.println("Admitted patient details : " + patient);
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
        Patient patient = new Patient(name, convertedDob, convertedDateAdmitted, diagnosis);
        patients.add(patient);
        return patient;
    }

    public static Date covertStringToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }

    public static void showAllPatientOnFloor() {
        System.out.println("enter floor number starts from 1");
        Scanner scanner = new Scanner(System.in);
        List<Patient> patients = getPatientsByFloor(scanner.nextInt());
        CommonManager.printList(patients);
    }


    //    provide method to show all patients on a floor
    public static List<Patient> getPatientsByFloor(int floorNo) {
        List<Patient> patientsOnFloor = new ArrayList<>();

        List<Bed> bedsOnFloor = new ArrayList<>();

//        filter room on the basis of floor and get beds from the room
        for (Room room : HospitalManager.hospital.getRooms()) {
            if (room.getFloor() == floorNo) {
                bedsOnFloor.addAll(room.getBeds());
            }
        }

        for (Patient p : patients) {
            if (bedsOnFloor.contains(p.getBed())) {
                patientsOnFloor.add(p);
            }
        }
        return patientsOnFloor;
    }

//    public static void roomPatientReport() {
//
//        List<Bed> allBeds = new ArrayList<>();
//
////        filter room on the basis of floor and get beds from the room
//        for (Room room : HospitalManager.hospital.getRooms()) {
//            allBeds.addAll(room.getBeds());
//        }
//        String report = "RoomNumber           Patient\n";
//        for (Room r : HospitalManager.hospital.getRooms()) {
//            report = report + "\t" + r.getRoomNumber();
//            int patientCount = 0;
//            for (Bed b : r.getBeds()) {
//                if (b.isOccupied()) {
//                    patientCount++;
//                }
//            }
//            report = report + "\t\t\t\t\t\t" + patientCount + "\n";
//        }
//        System.out.println(report);
//    }

}
