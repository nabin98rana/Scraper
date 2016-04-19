/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows.dao.impl;

import com.leapfrog.fiows.dao.EmployeeDAO;
import com.leapfrog.fiows.entity.Employee;
import com.leapfrog.fiows.util.CSVHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Navin
 */
public class EmployeeDAOImpl implements EmployeeDAO {
private List<Employee> employeeList=new ArrayList<>();
    @Override
    public void insert(Employee t) {
        employeeList.add(t);
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public void loadFromFile(String fileName)throws IOException {
        CSVHandler.read(fileName).forEach(r->{
            StringTokenizer tokens=new StringTokenizer(r,",");
            if(tokens.countTokens()>=6){
            Employee emp=new Employee();
            emp.setId(Integer.parseInt(tokens.nextToken()));
            emp.setFirstName(tokens.nextToken());
            emp.setLastName(tokens.nextToken());
            emp.setEmail(tokens.nextToken());
            emp.setContactNo(tokens.nextToken());
            emp.setStatus(Boolean.parseBoolean(tokens.nextToken()));
            
            insert(emp);
            }
        });
    }

    @Override
    public void export(String fileName, String content)throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
