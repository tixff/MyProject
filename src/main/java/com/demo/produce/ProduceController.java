package com.demo.produce;

import com.demo.common.model.Produce;
import com.demo.produce.ProduceService;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;

import java.util.Date;
import java.util.List;

/**
 * @author Ti
 * @date 2018/12/28
 */
public class ProduceController extends Controller {

    @Inject
    ProduceService service;

    public void findProduce(){
        List<Produce> produces = service.findProduceByTime("2018-12-28", "2018-12-29", "tom");
        Produce produce = produces.get(0);
        String json = JsonKit.toJson(produce);
        System.out.println("+++++++++json格式："+json);
        renderJson(json);
    }



}
