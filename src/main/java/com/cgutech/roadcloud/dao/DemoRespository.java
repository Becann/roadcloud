package com.cgutech.roadcloud.dao;

import com.cgutech.roadcloud.dao.entity.MongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Becan on 2017/6/7.
 */
public interface DemoRespository extends MongoRepository<MongoEntity,Long> {
}
