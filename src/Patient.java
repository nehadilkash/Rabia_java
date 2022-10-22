import java.util.Date;

public class Patient {
    private String patientName;
    private Date dob;
    private Date dateAdmitted;
    private String diagnosis;
    private Bed bed;

    public Patient(String patientName, Date dob, Date dateAdmitted) {
        this.patientName = patientName;
        this.dob = dob;
        this.dateAdmitted = dateAdmitted;
    }

    public Patient(String patientName, Date dob, Date dateAdmitted, String diagnosis) {
        this.patientName = patientName;
        this.dob = dob;
        this.dateAdmitted = dateAdmitted;
        this.diagnosis = diagnosis;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
}
