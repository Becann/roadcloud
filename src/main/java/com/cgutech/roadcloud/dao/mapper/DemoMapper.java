package com.cgutech.roadcloud.dao.mapper;

import com.cgutech.roadcloud.dao.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Becan on 2017/6/6.
 */
@Mapper
public interface DemoMapper {
    DemoEntity selectDemo(@Param("id") int id);
    void insertDemo(@Param("demo") DemoEntity demo);
    void deleteDemo(@Param("id") int id);
}
