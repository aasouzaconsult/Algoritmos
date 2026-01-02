import java.io.*;

public class Employee {
    
    String name;
    int age;
    String designation;
    double salary;

    public Employee(String name) {
        this.name = name;
    }

    public void empAge(int empAge) {
        this.age = empAge;
    }

    public void empDesignation( String empDesig) {
        this.designation = empDesig;
    } 

    public void empSalary(double empSalary) {
        this.salary = empSalary;
    }

    public void printEmployee() {
        System.out.println("Name:" + name);
        System.out.println("Age" + age);
        System.out.println("Designation" + designation);
        System.out.println("Salary" + salary);
    }
}