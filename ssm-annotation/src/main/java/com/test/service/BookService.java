package com.test.service;

import com.test.pojo.Book;

import java.util.Map;

public interface BookService {
    public Book getBook(int bookId);
    public void insertBook(Map<String,String> map);
}
