package com.demo.produce;

import com.demo.common.model.Produce;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ti
 * @date 2018/12/28
 */
public class ProduceService {

    private Produce dao = new Produce().dao();

    public List<Produce> findProduceByTime(String startTime,String endTime, String topicName) {
        String sql = "select * from produce where topic_name=\"" + topicName + "\"" + " and produce_time>\""+startTime+"\"" +" and produce_time<\""+endTime+"\"";
        List<Produce> produces = dao.find(sql);
        return produces;
    }

    public void addProduce(String topicName,Integer count){
        Date date = new Date();
        Produce produce = new Produce();
        produce.setCount(count);
        produce.setProduceTime(date);
        produce.setTopicName(topicName);
        produce.save();
    }

    public void deleteProduceByTopicName(String topicName){
        Produce produce = new Produce();
        produce.setTopicName(topicName);
        produce.delete();
    }

    public void updateProduceCountByTopicNameAndTime(String topicName,String addTime,Integer count){
        List<Produce> produces = dao.find("select *from produce where topic_name=\"" + topicName + "\"" + " and produce_time=\"" + addTime + "\"");
        Produce produce1 = produces.get(0);
        Integer id = produce1.getId();
        Produce produce = new Produce();
        produce.setId(id);
        produce.setCount(count+produce1.getCount());
        produce.update();
    }

    public static void main(String[] args) {
        String topicName = "tom";
        String startTime = "2018-12-28";
        String endTime = "2018-12-29";
        String sql = "select * from produce where topic_name = \"" + topicName + "\"" + " and produce_time>\""+startTime+"\"" +" and produce_time<\""+endTime+"\"";
        System.out.println(sql);
    }
}
