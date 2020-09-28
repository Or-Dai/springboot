package com.example.springboot.service;


import com.example.springboot.entity.Book;
import com.example.springboot.utils.Result;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    public Result getById(int id);
    public Result getByBookName(String bookName);
    public Result insert(Book book);
    public Result delete(int id);
    public Result update(Book book);
}