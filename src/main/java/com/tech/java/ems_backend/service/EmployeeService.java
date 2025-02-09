package com.tech.java.ems_backend.service;

import com.tech.java.ems_backend.dto.Employeedto;

import java.util.List;

public interface EmployeeService {

    Employeedto createEmployee(Employeedto employeedto);

    Employeedto getEmployeeById(Long employeeId);

    List<Employeedto> getAllEmployees();

    Employeedto updateEmployee(Long employeeId, Employeedto updateemployee);

    void deleteEmployee(Long employeeId);
}
