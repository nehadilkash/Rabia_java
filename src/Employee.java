public class Employee
//        implements Comparable<Employee>
{

    private String name;
    private int age;
    private int salary;
    private String address;

    public Employee(String name, int age, int salary, String address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    // e1.compareTo(e2)-----> e1 is this and e2 is o
    // if e1 salary is greater than positive value will be returned
    // if e1 salary is lesser than negative value will be returned
    // if e1 salary is equal to e2 salary zero will be returned
    // basically it's a short and correct implementation of if else old impl (compare it with old implementation)
//    @Override
//    public int compareTo(Employee o) {
//        return this.salary - o.getSalary();
//    }
}
