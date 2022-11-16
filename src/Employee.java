public class Employee implements Comparable<Employee> {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//    @Override
//    public int compareTo(Object o) {
//        Employee employee = (Employee) o;
//        if (this.salary > employee.getSalary())
//            return 1;
//        else if (this.salary == employee.getSalary())
//            return 0;
//        else
//            return -1;
//    }

    @Override
    public int compareTo(Employee o) {
        if (this.salary > o.getSalary())
            return 1;
        else if (this.salary == o.getSalary())
            return 0;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
