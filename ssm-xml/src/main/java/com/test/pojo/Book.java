package com.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer bookId;
    private String bookName;
    private Integer bookCounts;
    private String detail;
    private List<String> secondaryName;
    public static class Dog{}
}
