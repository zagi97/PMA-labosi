package com.example.prvavjezba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyDataStorage{

    public List<Student> students;

    public MyDataStorage()
    {
        students = new ArrayList<Student>();
    }

    static private MyDataStorage instance;

    static MyDataStorage getInstance()
    {
        if(instance == null)
        {
            instance = new MyDataStorage();
        }
        return instance;
    }

    public void setStudents(Student student)
    {
        students.add(student); //dodaj this
    }

    public List<Student> getStudents()
    {
        return students;
    }

}
