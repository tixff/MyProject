package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

public class BaseInfo <M extends BaseInfo<M>> extends Model<M> implements IBean {
    public M setId(Integer id) {
        set("id", id);
        return (M)this;
    }

    public Integer getId() {
        return getInt("id");
    }

    public M setName(String name) {
        set("name", name);
        return (M)this;
    }

    public String getName() {
        return getStr("name");
    }

    public M setPassword(String password) {
        set("password", password);
        return (M)this;
    }

    public java.lang.String getPassword() {
        return getStr("password");
    }
}
