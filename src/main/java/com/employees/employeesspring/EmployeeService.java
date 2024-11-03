package com.employees.employeesspring;

import java.util.List;

public interface EmployeeService {
    String addEmployee(String name, String surname);

    String deleteEmployee(String name, String surname);

    String findEmployee(String name, String surname);

    List<Employee> getAllEmployees();
}
