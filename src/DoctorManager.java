import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DoctorManager {

    static List<Doctor> doctors = new ArrayList<>();

    public static void joinDoctors() {
        Doctor doctor1 = new Doctor("doc1", new Date(2000, 2, 1, 0, 0, 0), "nuerologist");
        Doctor doctor2 = new Doctor("doc2", new Date(2000, 2, 1, 0, 0, 0), "OBGYN");
        Doctor doctor3 = new Doctor("doc3", new Date(2000, 2, 1, 0, 0, 0), "physician");
        Doctor doctor4 = new Doctor("doc4", new Date(2000, 2, 1, 0, 0, 0), "cardiologist");
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
    }

    public static void assignDoctor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter patient name : ");
        Patient patient = new Patient(scanner.nextLine());

        System.out.println("enter doctor name : ");
        Doctor doctor = new Doctor(scanner.nextLine());

        if (PatientManager.patients.contains(patient)) {
            patient = PatientManager.patients.get(PatientManager.patients.indexOf(patient));
        }
        if (DoctorManager.doctors.contains(doctor)) {
            doctor = DoctorManager.doctors.get(DoctorManager.doctors.indexOf(doctor));
        }

        System.out.println(doctor);
        System.out.println(patient);

        doctor.getPatients().add(patient);
        patient.getDoctors().add(doctor);

    }

    public static void showPatientsForDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter doctor name : ");
        Doctor doctor = new Doctor(scanner.nextLine());
        if (DoctorManager.doctors.contains(doctor)) {
            doctor = DoctorManager.doctors.get(DoctorManager.doctors.indexOf(doctor));
        }
        CommonManager.printList(doctor.getPatients());
    }

    public static void showDoctors() {
        String report = "PatientName           DoctorName\n";
        for (Patient p : PatientManager.patients) {
            report = report + "\t" + p.getName();
            for (Doctor d : p.getDoctors()) {
                report = report + "\n\t\t\t\t\t\t" + d.getName() + "(" + d.getSpecialization() + ")\n";
            }
        }

        System.out.println(report);
    }
}
