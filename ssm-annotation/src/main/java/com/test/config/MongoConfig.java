package com.test.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

//
//@Configuration
//public class MongoConfig {
//    @Bean
//    public MongoClient mongoClient(){
//        ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
//        MongoCredential mongoCredential = MongoCredential.createCredential("","runoob",null);
//        List<MongoCredential> list = new ArrayList<>();
//        list.add(mongoCredential);
//        return null;
//    }
//    @Bean
//    public MongoDatabaseFactory mongoDatabaseFactory(){
//        return new SimpleMongoClientDatabaseFactory(mongoClient(),"runoob");
//    }
//    @Bean
//    public MongoOperations mongoTemplate(){
//        return new MongoTemplate(MongoClients.create(),"runoob");
//    }
//}
