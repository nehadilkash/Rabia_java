public class PayRoll {
    int[] employeeId = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
    int[] hours = new int[7];
    double[] payRate = new double[7];
    double[] wages = new double[7];

    public int[] getEmployeeId() {
        return employeeId;
    }


    public int[] getHours() {
        return hours;
    }

    public void setHour(int hour, int i) {
        this.hours[i]=hour;
    }

    public double[] getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate, int i) {
        this.payRate[i] = payRate;
    }

    public double[] getWages() {
        return wages;
    }

    public void setWage(double wage, int i) {
        this.wages[i] = wage;
    }

    public double calculateWage(int hours, double payRate) {

        return hours * payRate;
    }

    public double getGrossPay(int id) {
        for (int i = 0; i < 7; i++) {
            if (id == employeeId[i]) {
                return wages[i] * 365;
            }
        }
        return 0;
    }

}
