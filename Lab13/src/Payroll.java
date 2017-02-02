import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhscompsci on 2/1/17.
 */
public class Payroll {
    private static List<SalaryEmployee> SalaryEmployees = new ArrayList<SalaryEmployee>();
    private static List<HourlyEmployee> HourlyEmployees = new ArrayList<HourlyEmployee>();

    public static void main(String[] args) {

    }
    public static void addHourlyEmployee(String employeeID, String name, double hourlyRate) {
        int insertPos = 0;
        HourlyEmployee employee = (new HourlyEmployee(employeeID, name, hourlyRate));
        for(int i = 0; i < SalaryEmployees.size(); i++) {
            if (HourlyEmployees.get(i).getName().compareToIgnoreCase(HourlyEmployees.get(i + 1).getName()) < 0) {
            insertPos = i;
            break;
            }
            HourlyEmployees.add(insertPos, employee);
        }
    }
    public static void addSalaryEmployee(String employeeID, String name, double salary) {
        int insertPos = 0;
        SalaryEmployee employee = (new SalaryEmployee(employeeID, name, salary));
        for(int i = 0; i < SalaryEmployees.size(); i++) {
            if (SalaryEmployees.get(i).getName().compareToIgnoreCase(SalaryEmployees.get(i + 1).getName()) < 0) {
            insertPos = i;
            break;
            }
            SalaryEmployees.add(insertPos, employee);
        }
    }
    public static double getHoursWorked() {
        double totalHours = 0;

        for(HourlyEmployee employee : HourlyEmployees) {
            totalHours += employee.getHoursWorked();
        }
        return totalHours;
    }
    public static void deleteEmployee(String employeeID) {
        for(SalaryEmployee employee : SalaryEmployees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                SalaryEmployees.remove(employee);
                break;
            }
        }
        for(HourlyEmployee employee : HourlyEmployees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                HourlyEmployees.remove(employee);
                break;
            }
        }
    }
    public static double getWeeklyPay() {
        double totalPay = 0;
        for (SalaryEmployee employee : SalaryEmployees) {
            totalPay += employee.getWeeklyPay();
        }
        for (HourlyEmployee employee : HourlyEmployees) {
            totalPay += employee.getWeeklyPay();
        }
        return totalPay;
    }
}
