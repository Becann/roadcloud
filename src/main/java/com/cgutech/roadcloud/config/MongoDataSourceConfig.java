package com.cgutech.roadcloud.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Becan on 2017/6/8.
 */
@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan
@EnableMongoRepositories
//@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoDataSourceConfig extends AbstractMongoConfiguration{

    /**
     * Default port used when the configured port is {@code null}.
     */
    public static final int DEFAULT_PORT = 27017;

    /**
     * Mongo server host.
     */
   // @Value("${host}")
    private String host;

    /**
     * Mongo server port.
     */
   // @Value("${port}")
    private Integer port = null;
    /**
     * Database name.
     */
   @Value("${spring.data.mongodb.database}")
    private String database;
    /**
     * Login user of the mongo server.
     */
    //@Value("${username}")
    private String username;

    /**
     * Login password of the mongo server.
     */
   // @Value("${password}")
    private char[] password;

    /**
     * Mongo database URI. When set, host and port are ignored.
     */
    @Value("${spring.data.mongodb.uri}")
    private String uri = "mongodb://localhost/test";

    @Override
    protected String getDatabaseName() {
        return database;
    }



    @Override
    @Bean
    public Mongo mongo() throws Exception {
        /*ServerAddress serverAdress = new  ServerAddress(host, port);
        MongoCredential credential = MongoCredential.createMongoCRCredential(username, database , password);
        //Do not use new Mongo(), is deprecated.
        Mongo mongo =  new MongoClient(serverAdress, Arrays.asList(credential));*/
        Mongo mongo =new MongoClient(new MongoClientURI(uri));
        return mongo;
    }
}
