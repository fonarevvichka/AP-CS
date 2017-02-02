/**
 * Created by lhscompsci on 1/30/17.
 */
public abstract class Employee {
    private String employeeID, name;

    public Employee(String employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public String getName() {
        return name;
    }
    public void changeEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public void changeName(String name) {
        this.name = name;
    }
    public String toString() {
        return name + "'s employee number is " + employeeID + ". ";
    }
}
