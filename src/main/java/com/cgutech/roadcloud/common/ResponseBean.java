package com.cgutech.roadcloud.common;

import com.cgutech.roadcloud.dao.entity.DemoEntity;
import com.cgutech.roadcloud.dao.entity.MongoEntity;

/**
 * Created by Becan on 2017/6/6.
 */
public class ResponseBean {
    private Result result;
    private DemoEntity demo;
    private MongoEntity mongo;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public DemoEntity getDemo() {
        return demo;
    }

    public void setDemo(DemoEntity demo) {
        this.demo = demo;
    }

    public MongoEntity getMongo() {
        return mongo;
    }

    public void setMongo(MongoEntity mongo) {
        this.mongo = mongo;
    }
}
