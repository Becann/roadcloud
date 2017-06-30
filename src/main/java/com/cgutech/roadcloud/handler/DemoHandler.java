package com.cgutech.roadcloud.handler;

import com.cgutech.roadcloud.dao.entity.DemoEntity;

/**
 * Created by Becan on 2017/6/6.
 */
public interface DemoHandler {
    DemoEntity getDemoById(int id);
    void saveDemo(DemoEntity demo);
    void deleteDemoById(int id );
}
