package com.cgutech.roadcloud.controller;

import com.cgutech.roadcloud.common.ResponseBean;
import com.cgutech.roadcloud.common.Result;
import com.cgutech.roadcloud.dao.entity.DemoEntity;
import com.cgutech.roadcloud.dao.entity.MongoEntity;
import com.cgutech.roadcloud.handler.DemoHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Becan on 2017/6/6.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoHandler demoHandler;
    @Autowired
    MongoTemplate template;

    private Logger logger = Logger.getLogger(DemoController.class);

    @RequestMapping("/save")
    public ResponseBean saveDemo(@RequestParam(value = "distribute",defaultValue = "hello")String distribute,
                           @RequestParam(value="id",defaultValue = "1")int id){
        ResponseBean result = new ResponseBean();
        Result result1 = new Result();
        DemoEntity demo = new DemoEntity(id,distribute);
        result.setDemo(demo);
        try{
            demoHandler.saveDemo(demo);
        }catch (Exception e){
            logger.error(e);
            result1.setMessage("error:"+e.getMessage());
            result1.setCode(400);
        }
        result.setResult(result1);
        return result;
    }

    @RequestMapping("/get")
    public ResponseBean getDemo(@RequestParam(value="id",defaultValue = "1")int id){
        ResponseBean result = new ResponseBean();
        Result rs = new Result();
        DemoEntity demo;
        try{
            demo=demoHandler.getDemoById(id);
        }catch (Exception e){
            logger.error(e);
            rs.setMessage("error:"+e.getMessage());
            rs.setCode(400);
            result.setResult(rs);
            return result;
        }
        result.setResult(rs);
        result.setDemo(demo);
        return result;
    }


    @RequestMapping("/savemongo")
    public ResponseBean saveDemoMongo(@RequestParam(value = "desc",defaultValue = "hello")String desc,
                                 @RequestParam(value="id",defaultValue = "123456")String id,
                                      @RequestParam(value = "name",defaultValue = "mongo")String name){
        ResponseBean result = new ResponseBean();
        Result result1 = new Result();
        MongoEntity demo = new MongoEntity(id,name,desc);
        result.setMongo(demo);
        try{
           template.save(demo);
        }catch (Exception e){
            logger.error(e);
            result1.setMessage("error:"+e.getMessage());
            result1.setCode(400);
        }
        result.setResult(result1);
        return result;
    }
}
