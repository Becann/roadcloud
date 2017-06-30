package com.cgutech.roadcloud;

import com.cgutech.roadcloud.dao.entity.MongoEntity;
import com.cgutech.roadcloud.util.TextFile;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

/**
 * Created by Becan on 2017/6/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    MongoTemplate template;
    @Test
    public void saveMongo(){
        MongoEntity mongo = new MongoEntity();
        mongo.setId(new String("123456"));
        mongo.setName("mongo");
        mongo.setDisc("java mongo test");
        template.save(mongo,"demo");
        //template.dropCollection(MongoEntity.class);
        //demo.save(mongo);
    }

    @Test
    public void saveFile() throws IOException {
        DB db = template.getDb();
        GridFS fs = new GridFS(db);
        GridFSFile file = fs.createFile(new File("D:\\data\\lat_lng"));
        file.save();
    }

    @Test
    public void getFile() throws IOException {
        DB db = template.getDb();
        GridFS fs = new GridFS(db);
        GridFSDBFile dbf = fs.findOne("lat_lng");
        System.out.println(TextFile.read(dbf.getInputStream()));
    }

}
