package com;

import com.ti.annotation.BeanScan;
import com.ti.dao.impl.BaseDaoImpl;

import java.util.ArrayList;
@BeanScan
public class JDBCstudent extends BaseDaoImpl<Student>{
    ArrayList<Student> findAllStudent(){
       return finaAll(new Student(),new Student().getTable());
    }
}
