package com.cgutech.roadcloud.handler;

import com.cgutech.roadcloud.dao.DemoDao;
import com.cgutech.roadcloud.dao.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Becan on 2017/6/6.
 */
@Service
public class DemoHandlerImpl implements DemoHandler {
    @Autowired
    private DemoDao demoDao;
    @Override
    public DemoEntity getDemoById(int id) {
        return demoDao.getDemo(id);
    }

    @Override
    public void saveDemo(DemoEntity demo) {
        demoDao.saveDemo(demo);
    }

    @Override
    public void deleteDemoById(int id) {
        demoDao.deleteDemeo(id);
    }
}
