import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        PayRoll payRoll = new PayRoll();

        int[] employeeIds = payRoll.getEmployeeId();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < payRoll.employeeId.length; i++) {
            System.out.println("**********Employee : " + (i + 1) + "********");
            System.out.println("Employee Id: " + employeeIds[i]);
            System.out.println("please enter hours");
            int hr = scanner.nextInt();
            //set hr to particular employee denoted by index i
            payRoll.setHour(hr, i);
            System.out.println("please enter payRate");
            double payRate = scanner.nextDouble();
            //set payrate to particular employee denoted by index i3
            payRoll.setPayRate(payRate, i);
            double wage = payRoll.calculateWage(hr, payRate);
            payRoll.setWage(wage, i);
            System.out.println(" Calculated wage : " + wage);
        }
        System.out.println("***********GROSS PAY************");
        for (int i = 0; i < payRoll.employeeId.length; i++) {
            System.out.println("gross pay for employee id : " + employeeIds[i] + " is " + payRoll.getGrossPay(employeeIds[i]));
        }
    }
}
