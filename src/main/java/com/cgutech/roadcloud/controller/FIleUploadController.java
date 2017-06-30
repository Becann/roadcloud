package com.cgutech.roadcloud.controller;

import com.cgutech.roadcloud.common.ResponseBean;
import com.cgutech.roadcloud.common.Result;
import com.cgutech.roadcloud.dao.entity.DemoEntity;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Becan on 2017/6/8.
 */
@Controller
public class FIleUploadController {
    @Autowired
    private MongoTemplate template;
    private Logger logger = Logger.getLogger(DemoController.class);

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseBean saveDemo(@RequestParam(value = "name")String name,
                                 @RequestParam("file")MultipartFile file){
        ResponseBean result = new ResponseBean();
        Result result1 = new Result();
        DB db = template.getDb();
        GridFS fs = new GridFS(db);
        try{
            GridFSFile gfs = fs.createFile(file.getInputStream(),name);
            gfs.save();
        }catch (IOException e){
            logger.error(e);
            result1.setMessage("error:"+e.getMessage());
            result1.setCode(400);
        }

        logger.info("成功上传文件："+ name);
        result.setResult(result1);
        return result;
    }
}
