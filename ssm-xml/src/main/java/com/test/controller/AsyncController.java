package com.test.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;
@Controller
public class AsyncController {
    
    @Async("myExecutor")
    @GetMapping("/getStr")
    @ResponseBody
    public String getStr() {
        System.out.println(Thread.currentThread() + "11111111111");
        return Thread.currentThread() + "11111111111";
    }
    @Async
    @GetMapping("/getStr1")
    @ResponseBody
    public String getStr1() {
        System.out.println(Thread.currentThread() + "22222222222");
        return Thread.currentThread() + "22222222222";
    }
//    @GetMapping("/setStr")
    public Future<String> setStr() {
        return AsyncResult.forValue("123124321");
    }
}
