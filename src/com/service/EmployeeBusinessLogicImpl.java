package com.service;

import java.util.LinkedList;

import com.dto.Employee;
import com.exceptions.EmployeeIdNotFoundException;
import com.persistence.EmployeeDataAccess;
import com.persistence.EmployeeDataAccessImpl;
import com.exceptions.EmployeeIdNotFoundException;

public class EmployeeBusinessLogicImpl implements EmployeeBusinessLogic {


    private EmployeeDataAccess dataAccess=new EmployeeDataAccessImpl();

    private LinkedList<Employee> employeeList;

    public EmployeeBusinessLogicImpl() {
        try {
            employeeList=dataAccess.readRecords();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public LinkedList<Employee> getAllEmployees() {

        return employeeList;
    }

    @Override
    public boolean addEmployee(Employee employee) {

        return employeeList.add(employee);
    }

    @Override
    public void deleteEmployee(int id) throws EmployeeIdNotFoundException {
        boolean status = false;
        for(Employee employee:employeeList) {
            if(id==employee.getEmpId())
                status = employeeList.remove(employee);
        }
        if(status == false)
            throw new EmployeeIdNotFoundException("Employee id " + id + " not found");
    }

    public void saveAllEmployees() {
        try {
            dataAccess.writeRecords(employeeList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //@Override
    //public Employee searchEmployee(int id) {
    //    Employee result = null;
    //    for(Employee employee : employeeList) {
    //        if (id == employee.getEmpId())
    //            result = employee;
    //    }
    //    return result;
    //}

    @Override
    public Employee searchEmployee(int id) throws EmployeeIdNotFoundException{
        Employee result = null;
        for(Employee employee : employeeList) {
            if (id == employee.getEmpId())
                result = employee;
        }
        if(result == null)
            throw new EmployeeIdNotFoundException("Employee id " + id + " not found");
        return result;
    }


}
