import java.util.Date;
import java.util.Objects;

public class Person {
    private String name;
    private Date dob;
    private String contactInfo;
    private String Address;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Date dob) {
        this.name = name;
        this.dob = dob;
    }

    public Person(String name, Date dob, String contactInfo, String address) {
        this.name = name;
        this.dob = dob;
        this.contactInfo = contactInfo;
        Address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", contactInfo='" + contactInfo + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
