/**
 * Created by lhscompsci on 2/1/17.
 */
public class SalaryEmployee extends Employee {
    private double salary;

    public SalaryEmployee(String name, String employeeID, double salary) {
        super(employeeID, name);

        this.salary = salary;
    }
    public void changeSalary(double change) {
        this.salary += change;
    }
    public double getWeeklyPay() {
        return salary/52;
    }
    public String toString() {
        return super.toString() + "Their salary is " + salary + ". ";
    }
}
