import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmplyeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("neha", 25, 500000000, "test1");
        Employee e2 = new Employee("abc", 26, 450000000, "test2");
        Employee e3 = new Employee("fw", 25, 480000000, "test1");
        Employee e4 = new Employee("asdjh", 26, 610000000, "test2");
//
//        System.out.println(e1.compareTo(e2));//positive

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

//        ListIterator<Employee> itr = employees.listIterator();

        System.out.println("---------------BEFORE SORTING EMPLOYEES--------------------");

//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }

        for (Employee e : employees) {
            System.out.println(e);
        }

        Collections.sort(employees);

        System.out.println("---------------AFTER SORTING EMPLOYEES(By default salary comparable)--------------------");

//        Iterator<Employee> itr2 = employees.iterator();
//        while (itr2.hasNext()) {
//            System.out.println(itr2.next());
//        }

        for (Employee e : employees) {
            System.out.println(e);
        }


        System.out.println("---------------AFTER SORTING EMPLOYEES(on basis of name)--------------------");

        Collections.sort(employees, new EmployeeNameComparator());

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("---------------AFTER SORTING EMPLOYEES(on basis of age)--------------------");

        Collections.sort(employees, new EmployeeAgeComparator());

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
