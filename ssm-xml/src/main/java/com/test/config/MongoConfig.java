package com.test.config;

import com.mongodb.Mongo;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfig {
    @Bean
    public MongoClient mongoClient(){
        ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
        MongoCredential mongoCredential = MongoCredential.createCredential("","runoob",null);
        List<MongoCredential> list = new ArrayList<>();
        list.add(mongoCredential);
        return null;
    }
    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory(){
        return new SimpleMongoClientDatabaseFactory(mongoClient(),"runoob");
    }
    @Bean
    public MongoOperations mongoTemplate(){
        return new MongoTemplate(MongoClients.create(),"runoob");
    }
}
