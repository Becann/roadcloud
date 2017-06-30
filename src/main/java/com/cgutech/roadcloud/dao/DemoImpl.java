package com.cgutech.roadcloud.dao;

import com.cgutech.roadcloud.dao.entity.DemoEntity;
import com.cgutech.roadcloud.dao.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Becan on 2017/6/6.
 */
@Service
public class DemoImpl implements DemoDao{
    @Autowired
    DemoMapper demoMapper;
    @Override
    public DemoEntity getDemo(int id) {
        return demoMapper.selectDemo(id);
    }

    @Override
    public void saveDemo(DemoEntity demo) {
        demoMapper.insertDemo(demo);
    }

    @Override
    public void deleteDemeo(int id) {
        demoMapper.deleteDemo(id);
    }
}
