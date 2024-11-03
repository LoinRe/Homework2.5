package com.employees.employeesspring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //Шаг 10
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Шаг 11
    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в список сотрудников";
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.deleteEmployee(name, surname);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.findEmployee(name, surname);
    }

    //Шаг 12
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); // Возвращаем список всех сотрудников
    }
}