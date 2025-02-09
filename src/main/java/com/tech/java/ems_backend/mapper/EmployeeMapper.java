package com.tech.java.ems_backend.mapper;


import com.tech.java.ems_backend.dto.Employeedto;
import com.tech.java.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static Employeedto mapToEmployeedto(Employee employee) {
         return  new Employeedto(
                 employee.getId(),
                 employee.getFirstname(),
                 employee.getLastname(),
                 employee.getEmail()
         );
    }
    public static Employee mapToEmployee(Employeedto employeedto) {
        return  new Employee(
                employeedto.getId(),
                employeedto.getFirstname(),
                employeedto.getLastname(),
                employeedto.getEmail()
        );
    }
}
