package com.employees.employeesspring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Шаг 7
@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {

        super("Превышен лимит количества сотрудников в фирме");
    }
}
