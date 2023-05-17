package com.Employee.Repository;

import java.util.List;

import com.Employee.model.Employee;

public interface SearchRepo {

    public List<Employee> findByUnit(String text);

}
