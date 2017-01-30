/**
 * Created by lhscompsci on 1/30/17.
 */
public abstract class Employee {
    private String employeeID, name;
    private double hourlyRate, salary;

    public void Employee(String employeeID, String name, double hourlyRate, double salary) {
        this.employeeID = employeeID;
        this.name = name;

        this.hourlyRate = hourlyRate;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public double getHourlyPay(double hours) {
        if(hourlyRate != 0) {
            return ((hours/40)*40 * hourlyRate) + ((hours % 40) * hourlyRate * 1.5);
        } else {
            return salary/52;
        }
    }

    public void changeEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public void changeSalary(double change) {
        this.salary += change;
    }

    public void changeRate(double change) {
        this.hourlyRate += change;
    }

    public void changeName(String name) {
        this.name = name;
    }


}
