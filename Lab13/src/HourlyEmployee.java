/**
 * Created by lhscompsci on 2/1/17.
 */
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked = 0;

   public HourlyEmployee(String name, String employeeID, double hourlyRate) {
        super(employeeID, name);

        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }
    public double getWeeklyPay() {
        if (hoursWorked <= 40) {
            return hourlyRate * hoursWorked;
        } else {
            return hourlyRate * 40 + (hourlyRate * 1.5) * hoursWorked % 40;
        }
    }
    public void addHoursWorked(double hoursWorked) {
        this.hoursWorked += hoursWorked;
    }
    public void changeRate(double change) {
        this.hourlyRate += change;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public String toString() {
        return super.toString() + "Their hourly rate is " + hourlyRate + ". ";
    }
}
