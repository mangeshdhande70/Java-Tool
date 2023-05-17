package com.Employee.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


@Document(collection = "Employee")
public class Employee {


    String empName;
    Integer empId;
    String profile;
    String unit;
    String project[];

    public Employee(){

    }



    public String getEmpName() {
        return empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getProfile() {
        return profile;
    }

    public String getUnit() {
        return unit;
    }

    public String[] getProject() {
        return project;
    }

    @Override
    public String toString() {
        return "employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", profile='" + profile + '\'' +
                ", unit='" + unit + '\'' +
                ", project=" + Arrays.toString(project) +
                '}';
    }
}
