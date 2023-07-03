package com.test.service.Impl;

import com.test.dao.BookMapper;
import com.test.pojo.Book;
import com.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class BookServiceImpl implements BookService {
//    @Autowired(required = false)
    @Autowired
    private BookMapper bookMapper;

//    public void setBookMapper(BookMapper bookMapper) {
//        this.bookMapper = bookMapper;
//    }

    public Book getBook(int bookId) {
        Book book = bookMapper.getBook(bookId);
        return book;
    }
    public void insertBook(Map<String,String> map){
        bookMapper.insertBook(map);
    }
}
