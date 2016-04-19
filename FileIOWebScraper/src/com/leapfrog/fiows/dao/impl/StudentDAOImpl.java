/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.fiows.dao.impl;

import com.leapfrog.fiows.dao.StudentDAO;
import com.leapfrog.fiows.entity.Employee;
import com.leapfrog.fiows.entity.Student;
import com.leapfrog.fiows.util.CSVHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Navin
 */
public class StudentDAOImpl implements StudentDAO {

    private List<Student> studentList = new ArrayList<>();

    @Override
    public void insert(Student t) {
        studentList.add(t);
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void loadFromFile(String fileName) throws IOException {
        CSVHandler.read(fileName).forEach(r -> {
            StringTokenizer tokens = new StringTokenizer(r, ",");
            if (tokens.countTokens() >= 6) {
                Student std = new Student();
                std.setId(Integer.parseInt(tokens.nextToken()));
                std.setFirstName(tokens.nextToken());
                std.setLastName(tokens.nextToken());
                std.setEmail(tokens.nextToken());
                std.setContactNo(tokens.nextToken());
                std.setStatus(Boolean.parseBoolean(tokens.nextToken()));

                insert(std);
            }
        });
    }

    @Override
    public void export(String fileName, String content) throws IOException {
         StringBuilder builder=new StringBuilder();
        for(Student std:studentList){
        builder.append(std.toCSV());

        }
        CSVHandler.write(fileName, builder.toString());
    }

}
