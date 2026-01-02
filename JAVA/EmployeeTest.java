import java.io.*;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee empOne = new Employee("Gary");
        Employee empTwo = new Employee("Josephine");

        empOne.empAge(26);
        empOne.empDesignation("engineer");
        empOne.empSalary(1000);
        empOne.printEmployee();
    }
}