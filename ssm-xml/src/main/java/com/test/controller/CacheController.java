package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.pojo.Book;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class CacheController {
    @Autowired
    private BookService bookService;

    @Cacheable("cache1")
    @GetMapping(value = "getList")
    @ResponseBody
    public String getList() {
        Arrays.asList("spring", "mysql", "java高并发", "maven").toString();
        return "高并发";
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
