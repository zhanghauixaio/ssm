package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pojo.Book;
import com.test.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class CacheController {
    @Autowired
    private BookService bookService;

    @Cacheable(value = "redisCache",key = "#root.targetClass.name")
    @GetMapping(value = "getList")
    @ResponseBody
    public String getList() {
        log.info("命中缓存");
        final List<String> strings = Arrays.asList("spring", "mysql", "java高并发", "maven");
        return strings.toString();
    }
    @GetMapping("getJackson")
    @ResponseBody
    public String getJackson() throws JsonProcessingException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Book book = bookService.getBook(1);
        return objectMapper.writeValueAsString(book);
    }
    @GetMapping("getBook")
    @ResponseBody
    public Book getBook() {
        return bookService.getBook(1);
    }
    @GetMapping("getFastJson")
    @ResponseBody
    public String getFastJson(){
        final Book book = bookService.getBook(1);
        return JSON.toJSONString(book);
    }
}
