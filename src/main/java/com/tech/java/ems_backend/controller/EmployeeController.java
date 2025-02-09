package com.tech.java.ems_backend.controller;

import com.tech.java.ems_backend.dto.Employeedto;
import com.tech.java.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    public EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employeedto> createEmployee(@RequestBody Employeedto employeedto) {
        Employeedto saveEmployee = employeeService.createEmployee(employeedto);
        return  new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<Employeedto> getEmployeeById (@PathVariable("id") Long employeeId){
        Employeedto employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employeedto>> getAllEmployees(){
        List<Employeedto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employeedto> updateEmployee(@PathVariable ("id") Long employeeId, @RequestBody Employeedto updateEmployee){
        Employeedto employeedto = employeeService.updateEmployee(employeeId, updateEmployee);
        return new ResponseEntity<>(employeedto,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable ("id") Long employeeId){

        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
