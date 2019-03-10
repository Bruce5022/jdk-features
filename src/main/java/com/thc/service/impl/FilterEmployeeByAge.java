package com.thc.service.impl;

import com.thc.model.Employee;
import com.thc.service.MyPredicate;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
