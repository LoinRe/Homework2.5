package com.employees.employeesspring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Шаг 8
@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Вы пытаетесь добавить сотрудника, который уже добавлен");
    }
}
