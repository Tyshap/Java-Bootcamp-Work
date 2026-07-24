package com.academy.analytics;

import java.util.ArrayList;
import java.util.List;

public final class EmployeeData {

    private EmployeeData() {
    }

    public static List<Employee> createSampleEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("E001", "John Smith", "IT", 165000, 12, 5, true));
        employees.add(new Employee("E002", "Alice Johnson", "Finance", 152000, 10, 5, true));
        // ... add 20–30 total across IT, HR, Finance, Sales, Marketing
        // Include at least one inactive (active = false)
        employees.add(new Employee("E003", "Tyler Shapiro", "IT", 50000, 2, 4, true));
        employees.add(new Employee("E004", "Janice Waters", "Marketing", 110000, 20, 5, true));
        employees.add(new Employee("E005", "Steven Miles", "Finance", 180000, 20, 5, true));
        employees.add(new Employee("E006", "Peter Piper", "Sales", 80000, 7, 2, true));
        employees.add(new Employee("E007", "Alex Echols", "IT", 70000, 2, 4, true));
        employees.add(new Employee("E008", "Shrek", "HR", 76000, 6, 3,  false));
        employees.add(new Employee("E009", "Alex Hall", "Marketing", 84000, 8, 4, true));
        employees.add(new Employee("E010", "Monkey D. Luffy", "Sales", 72000, 7, 2, false));
        employees.add(new Employee("E011", "Hannah Beth", "Marketing", 65000, 2, 4, true));
        employees.add(new Employee("E012", "Sammy Sosa", "Sales", 89000, 12, 5, true));
        employees.add(new Employee("E013", "Carlos Delgado", "IT", 115000, 14, 4, true));
        employees.add(new Employee("E014", "Hae-In Cha", "HR", 90000, 2, 5, true));
        employees.add(new Employee("E015", "Jack Black", "Marketing", 150000, 15, 4, true));
        employees.add(new Employee("E016", "Chuck Nasty", "IT", 125000, 10, 3, true));
        employees.add(new Employee("E017", "Cal Zimmerman", "IT", 65000, 1, 5, true));
        employees.add(new Employee("E018", "Lucilla Lullaby", "HR", 70000, 8, 3, true));
        employees.add(new Employee("E019", "The Boogie Man", "Finance", 150000, 17, 4, true));
        employees.add(new Employee("E020", "Carlos Beltran", "Finance", 50000, 1, 3, true));

        return employees;
    }
}