import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private List<Patient> patients = new ArrayList<>();

    public Doctor(String name) {
        super(name);
    }

    public Doctor(String name, Date dob, String specialization) {
        super(name, dob);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialization='" + specialization + '\'' +
                "} " + super.toString();
    }
}
