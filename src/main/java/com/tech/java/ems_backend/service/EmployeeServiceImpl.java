package com.tech.java.ems_backend.service;

import com.tech.java.ems_backend.dto.Employeedto;
import com.tech.java.ems_backend.entity.Employee;
import com.tech.java.ems_backend.exception.ResourceNotFoundException;
import com.tech.java.ems_backend.mapper.EmployeeMapper;
import com.tech.java.ems_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    public EmployeeRepository employeeRepository;

    @Override
    public Employeedto createEmployee(Employeedto employeedto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeedto);
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeedto(createdEmployee);
    }

    @Override
    public Employeedto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id "+ employeeId));
        return  EmployeeMapper.mapToEmployeedto(employee);
    }

    @Override
    public List<Employeedto> getAllEmployees() {

        List<Employee> employee = employeeRepository.findAll();
        return employee.stream().map((employees)-> EmployeeMapper.mapToEmployeedto(employees))
                .collect(Collectors.toList());
    }

    @Override
    public Employeedto updateEmployee(Long employeeId, Employeedto updateemployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
        -> new ResourceNotFoundException(
                "Employee is not exists with given id "+ employeeId));
        employee.setFirstname(updateemployee.getFirstname());
        employee.setLastname(updateemployee.getLastname());
        employee.setEmail(updateemployee.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeedto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()
                -> new ResourceNotFoundException(
                "Employee is not exists with given id "+ employeeId));

        employeeRepository.deleteById(employeeId);
    }
}
