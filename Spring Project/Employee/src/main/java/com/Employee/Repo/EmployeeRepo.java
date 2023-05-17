package com.Employee.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Employee.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
