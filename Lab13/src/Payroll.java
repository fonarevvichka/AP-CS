import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lhscompsci on 2/1/17.
 */
public class Payroll {
    private static List<SalaryEmployee> SalaryEmployees = new ArrayList<SalaryEmployee>();
    private static List<HourlyEmployee> HourlyEmployees = new ArrayList<HourlyEmployee>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        boolean quit = false;

        String userChoice = "";
        String name, id;
        Double pay;
        System.out.println("Welcome to the payroll application :" + " \n");

        while(!quit) {
                    System.out.println("Choose an option:" + " \n" +
                    "1. Add a salary employee" + "\n" +
                    "2. Add a hourly employee" + "\n" +
                    "3. Display Hourly Employees " + "\n" +
                    "4. Display Salary Employees" + "\n" +
                    "5. Remove an Employee" + "\n" +
                    "6. Get employee information" + "\n" +
                    "7. Get payroll" + "\n" +
                    "8. Get hours worked" + "\n" +
                    "9. Add hours to employee" + "\n" +
                    "Q. Quit" + "\n" + "\n" +
                    "Selection: ");
            userChoice = cin.next();
            //display menu
            switch(userChoice) {
                case "1":
                    System.out.println("Please enter a name: ");
                    name = cin.next();
                    System.out.println("Please enter an employeeID: ");
                    id = cin.next();
                    System.out.println("Please enter a salary: ");
                    pay = cin.nextDouble();

                    addSalaryEmployee(name, id, pay);
                    break;
                case "2":
                    System.out.println("Please enter a name: ");
                    name = cin.next();
                    System.out.println("Please enter an employeeID: ");
                    id = cin.next();
                    System.out.println("Please enter a hourlyRate: ");
                    pay = cin.nextDouble();

                    addHourlyEmployee(name, id, pay);
                    break;
                case "5":
                    System.out.println("What is the employee ID of the person you want to remove");
                    id = cin.next();
                    deleteEmployee(id);
                    break;
                case "4":
                    printSalaryEmployees();
                    break;
                case "3":
                    printHourlyEmployees();
                    break;
                case "6":
                    System.out.println("What is the id of the employee you want to find: ");
                    id = cin.next();
                    System.out.println(getEmployee(id));
                    break;
                case "7":
                    System.out.println("This week a total of $" + getWeeklyPay() + " was spent.");
                    break;
                case "8":
                    System.out.print("This week a total of " + getHoursWorked() + " hours were worked.");
                    break;
                case "9":
                    System.out.println("What is the employee ID: ");
                    id = cin.next();
                    System.out.println("how many hours would you like to add: ");
                    pay = cin.nextDouble();
                    addHoursToEmployee(id, pay);
                case "Q":
                    quit = true;
            }
        }
//        addHourlyEmployee("aaab", "Tricia", 100);
//        addHourlyEmployee("aaaa", "Andy", 100);
//
//        addSalaryEmployee("aaac", "David", 40000);
//        addSalaryEmployee("aaad", "John", 40000);

    }
    public static void addHourlyEmployee(String employeeID, String name, double hourlyRate) {
        int insertPos = 0;
        HourlyEmployee employee = (new HourlyEmployee(employeeID, name, hourlyRate));
        for(int i = 0; i < SalaryEmployees.size(); i++) {
            if (HourlyEmployees.get(i).getName().compareToIgnoreCase(name) > 0) {
                insertPos = i;
                break;
            } else {
                insertPos += 1;
            }
        }
        HourlyEmployees.add(insertPos, employee);
    }
    public static void addSalaryEmployee(String employeeID, String name, double salary) {
        int insertPos = 0;
        SalaryEmployee employee = (new SalaryEmployee(employeeID, name, salary));
        for(int i = 0; i < SalaryEmployees.size(); i++) {
            if (SalaryEmployees.get(i).getName().compareToIgnoreCase(name) > 0) {
                insertPos = i;
                break;
            } else {
                insertPos += 1;
            }
        }
        SalaryEmployees.add(insertPos, employee);
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
    public static void printHourlyEmployees() {
        System.out.println("Hourly Employees: ");
        for(HourlyEmployee employee : HourlyEmployees) {
            System.out.println(employee.toString());
        }
    }
    public static void printSalaryEmployees() {
        System.out.println("Salary Employees: ");

        for(SalaryEmployee employee : SalaryEmployees) {
            System.out.println(employee.toString());
        }
    }
    public static String getEmployee(String id) {
        for(SalaryEmployee employee : SalaryEmployees) {
            if(employee.getEmployeeID().equals(id)) {
               return employee.toString();
            }
        }
        for(HourlyEmployee employee : HourlyEmployees) {
            if(employee.getEmployeeID().equals(id)) {
                return employee.toString();
            }
        }
        return "An employee with that ID does not exist";
    }
    public static void addHoursToEmployee(String id, double hours) {
        HourlyEmployee employee = null;
        for(HourlyEmployee worker : HourlyEmployees) {
            if(employee.getEmployeeID().equals(id)) {
                employee = worker;
                break;
            }
        }
        employee.addHoursWorked(hours);
    }
}
