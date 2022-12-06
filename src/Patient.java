import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Patient extends Person {

    private Date dateAdmitted;
    private String diagnosis;
    private List<Doctor> doctors=new ArrayList<>();
    private Bed bed;

    public Patient(String name) {
        super(name);
    }

    public Patient(String patientName, Date dob, Date dateAdmitted, String diagnosis) {
        super(patientName, dob);
        this.dateAdmitted = dateAdmitted;
        this.diagnosis = diagnosis;
    }

    public Date getDateAdmitted() {
        return dateAdmitted;
    }

    public void setDateAdmitted(Date dateAdmitted) {
        this.dateAdmitted = dateAdmitted;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "dateAdmitted=" + dateAdmitted +
                ", diagnosis='" + diagnosis + '\'' +
                ", bed=" + bed +
                "} " + super.toString();
    }

}
