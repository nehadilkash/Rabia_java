import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        HospitalManager.createHospital();

        Scanner scanner = new Scanner(System.in);
        int op;
        do {
            showMenu();
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    PatientManager.admitPatient();
                    break;
                case 2:
                    PatientManager.showAllPatientOnFloor();
                    break;
                case 3:
                    HospitalManager.showAvailableBeds();
                    break;
                case 4:
                    HospitalManager.roomOccupancyReport();
                    break;
                case 5:
                    DoctorManager.assignDoctor();
                    break;
                case 6:
                    DoctorManager.showPatientsForDoctor();
                    break;
                case 7:
                    DoctorManager.showDoctors();
                    break;

                default:
                    System.out.println("you have entered wrong choice please reenter your selection");
            }
        } while (op != 8);

    }


    private static void showMenu() {
        System.out.println("******************     HOSPITAL " + HospitalManager.hospital.getHospitalName() + "     ************************");
        System.out.println("1.ADMIT PATIENT");
        System.out.println("2.SHOW ALL PATIENTS ON FLOOR");
        System.out.println("3.SHOW ALL AVAILABLE BED");
        System.out.println("4.SHOW ROOM OCCUPANCY REPORT");
        System.out.println("5.ASSIGN DOCTOR");
        System.out.println("6.SHOW PATIENTS FOR A DOCTOR");
        System.out.println("7.SHOW DOCTORS FOR PATIENTS");
        System.out.println("8.EXIT\n");
        System.out.println("PRESS action number\n");
    }


}
