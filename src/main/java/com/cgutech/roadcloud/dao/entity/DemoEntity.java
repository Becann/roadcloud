package com.cgutech.roadcloud.dao.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by Becan on 2017/6/6.
 */
public class DemoEntity implements Serializable{
    @Id
    private int id;
    private String distribute;
    public DemoEntity(){}
    public DemoEntity(int id,String distribute){
        this.id = id;
        this.distribute = distribute;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistribute() {
        return distribute;
    }

    public void setDistribute(String distribute) {
        this.distribute = distribute;
    }
}
