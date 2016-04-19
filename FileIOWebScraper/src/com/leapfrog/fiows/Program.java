/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows;

import com.leapfrog.fiows.dao.EmployeeDAO;
import com.leapfrog.fiows.dao.impl.EmployeeDAOImpl;
import com.leapfrog.fiows.entity.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Navin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      EmployeeDAO empDAO=new EmployeeDAOImpl();
        try {
            empDAO.loadFromFile("employee.csv");
            empDAO.getAll().forEach(e->{
                System.out.println(e.toString());
            });
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
