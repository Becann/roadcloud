package com.cgutech.roadcloud.dao.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by Becan on 2017/6/7.
 */
public class MongoEntity {
    @Id
    private String id;
    private String name;
    private String disc;

    public MongoEntity(){}
    public MongoEntity(String id,String name,String disc){
        this.id = id;
        this.name = name;
        this.disc = disc;
    }

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
