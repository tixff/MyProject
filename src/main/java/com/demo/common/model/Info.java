package com.demo.common.model;

import com.demo.common.model.base.BaseInfo;
import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

public class Info extends BaseInfo<Info> {
    public void hello(){
        System.out.println("hello git");
    }
}
