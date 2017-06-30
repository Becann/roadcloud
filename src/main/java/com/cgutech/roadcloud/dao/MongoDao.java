package com.cgutech.roadcloud.dao;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Becan on 2017/6/8.
 */
public interface MongoDao {
    void saveFile(File file);
    void saveFile(InputStream file,String name);
    void save(Object object);
    File getFile(String name);
}
