package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

import java.util.Date;

/**
 * @author Ti
 * @date 2018/12/28
 */
public abstract class BaseProduce<M extends BaseProduce<M>> extends Model<M> implements IBean {

    //id
    public M setId(java.lang.Integer id) {
        set("id", id);
        return (M) this;
    }

    public java.lang.Integer getId() {
        return getInt("id");
    }

    //topic_name
    public M setTopicName(java.lang.String topicName) {
        set("topic_name", topicName);
        return (M) this;
    }

    public java.lang.String getTopicName() {
        return getStr("topic_name");
    }

    //produce_time
    public M setProduceTime(Date date) {
        set("produce_time", date);
        return (M) this;
    }

    public Date getProduceTime() {
        return getDate("produce_time");
    }

    //count
    public M setCount(Integer count) {
        set("count", count);
        return (M) this;
    }

    public Integer getCount() {
        return getInt("count");
    }


}
