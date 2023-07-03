package com.test.dao;

import com.test.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface BookMapper {
    Book getBook(int bookId);

    @Insert("insert into book (bookID,bookName,bookCounts,detail) value(#{bookId},#{bookName},#{bookCounts},#{detail})")
    void insertBook(Map<String, String> map);
}
