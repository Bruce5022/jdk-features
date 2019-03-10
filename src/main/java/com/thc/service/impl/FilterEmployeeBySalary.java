package com.thc.service.impl;

import com.thc.model.Employee;
import com.thc.service.MyPredicate;

public class FilterEmployeeBySalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 3500;
    }
}
