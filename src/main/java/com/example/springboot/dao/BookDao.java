package com.example.springboot.dao;

import com.example.springboot.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    List<Book> findByBookNameLike(String bookName);

    public Book findByBookName(String bookName);




}
