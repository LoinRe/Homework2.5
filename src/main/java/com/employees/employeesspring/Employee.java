package com.employees.employeesspring;

public class Employee {
    private String name;
    private String surname;

    // конструктор
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee a2 = (Employee) other;
        return name.equals(a2.name) && surname.equals(a2.surname);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}

