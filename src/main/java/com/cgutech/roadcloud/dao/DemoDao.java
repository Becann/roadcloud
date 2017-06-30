package com.cgutech.roadcloud.dao;

import com.cgutech.roadcloud.dao.entity.DemoEntity;

/**
 * Created by Becan on 2017/6/6.
 */
public interface DemoDao {
    DemoEntity getDemo(int id) ;
    void saveDemo(DemoEntity demo);
    void deleteDemeo(int id);
}
