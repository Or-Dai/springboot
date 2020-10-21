package com.example.springboot.service.impl;

import com.example.springboot.dao.BookDao;
import com.example.springboot.entity.Book;
import com.example.springboot.service.BookService;
import com.example.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;



    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByBookNameLike(String bookName) {
        return bookDao.findByBookNameLike("%"+bookName+"%");
    }

    @Override
    public Result getById(Integer id) {
        Book book = bookDao.findById(id).get();//根据id查询用户;
        return Result.success(book);
    }

    @Override
    public Result getByBookName(String bookName) {
        Book book = bookDao.findByBookName(bookName);
        return Result.success(book);
    }

    @Override
    public Result insert(Book book) {
        Book old = this.bookDao.findByBookName(book.getBookName());
        if(old != null){
            return Result.error("书本已存在");
        }
        book = this.bookDao.save(book);
        return Result.success(book);
    }
    @Override
    public Result update(Book book){
        book = this.bookDao.save(book);
        return Result.success("修改成功!");
    }




    @Override
    public Result delete(Integer id){
        this.bookDao.deleteById(id);
        return Result.success("删除成功！");
    }

    /**
     * 设置分页查询所有信息
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page<Book> findAll(Integer page, Integer pageSize) {
        Pageable pageable= PageRequest.of(page,pageSize);
        Page<Book> pa=bookDao.findAll(pageable);

        return pa;
    }
}
