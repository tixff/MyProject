package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

public abstract class BaseBlogType<M extends BaseBlogType<M>> extends Model<M> implements IBean {
    public M setId(Integer id) {
        set("id", id);
        return (M) this;
    }

    public Integer getId() {
        return getInt("id");
    }

    public M setName(String name) {
        set("name", name);
        return (M) this;
    }

    public String getName() {
        return getStr("name");
    }

}
