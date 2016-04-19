/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows.dao.impl;

import com.leapfrog.fiows.dao.StudentDAO;
import com.leapfrog.fiows.entity.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Navin
 */
public class StudentDAOImpl implements StudentDAO {
private List<Student> studentList=new ArrayList<>();
    @Override
    public void insert(Student t) {
       studentList.add(t);
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void loadFromFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void export(String fileName, String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

