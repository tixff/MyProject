package com;

import com.ti.ApplicationStarter;
import com.ti.BeanFactory;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ApplicationStarter.init();
        JDBCstudent jdbCstudent = (JDBCstudent) BeanFactory.get("JDBCstudent");
        ArrayList<Student> allStudent = jdbCstudent.findAllStudent();
        allStudent.forEach(o->{
            System.out.println(o);
        });
    }
}
