package com.employees.employeesspring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //Шаг 4
    //поле с коллекцией сотрудников
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Svetlov"),
            new Employee("Igor", "Ivanov"),
            new Employee("Olga", "Akimova"),
            new Employee("Sveta", "Molchanova")

    ));
    //константа макс кол-во сотрудников
    private static final int maxNumOfEmployees = 5;

    //Шаг 5 и шаг 9
    //Метод - добавить сотрудника
    @Override
    public String addEmployee(String name, String surname) {
        Employee newEmployee = new Employee(name, surname);  //создаем сотрудника
        if (employees.size() >= maxNumOfEmployees) {
            throw new EmployeeStorageIsFullException(); //Шаг 9
//            return "Превышен лимит количества сотрудников в фирме";
        } else if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException();  //Шаг 9
//            return "Вы пытаетесь добавить сотрудника, который уже добавлен";
        } else {
            employees.add(newEmployee);  //закидываем его в коллекцию
            return "Сотрудник " + name + " " + surname + " добавлен в список. Общее кол-во: " + employees.size();
        }
    }


    //Метод - удалить сотрудника
    @Override
    public String deleteEmployee(String name, String surname) {
        Employee employeeToDelete = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                employeeToDelete = employee; //нашли сотрудника на удаление
            }
        }
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            return "Сотрудник " + name + " " + surname + " удален из списка";
        } else {
//            return "Сотрудник не найден";
            throw new EmployeeNotFoundException(); //Шаг 9
        }
    }


    //Метод - найти сотрудника
    @Override
    public String findEmployee(String name, String surname) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                return "Сотрудник найден: " + employee; // Возвращаем строковое представление сотрудника
            }
        }
        throw new EmployeeNotFoundException();  //Шаг 9
    }

    //Шаг 12
    //Метод - вывод в браузер всех сотрудников
    public List<Employee> getAllEmployees() {
        return employees; // Возвращаем список всех сотрудников
    }
}

