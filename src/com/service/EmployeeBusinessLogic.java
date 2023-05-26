package com.service;

import java.util.LinkedList;

import com.dto.Employee;
import com.exceptions.EmployeeIdNotFoundException;

public interface EmployeeBusinessLogic {

    LinkedList<Employee> getAllEmployees();
    boolean addEmployee(Employee employee);
    public void deleteEmployee(int id) throws EmployeeIdNotFoundException;
    public void saveAllEmployees();
    Employee searchEmployee(int id) throws EmployeeIdNotFoundException;
}
