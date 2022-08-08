package com.lfy.dao;

import com.lfy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookDaoTestTask {
    @Autowired
    private BookDao bookDao;
    @Test
    void testgetById(){
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("测试数据");
        book.setDescription("测试数据");
        book.setType("测试数据");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(21);
        book.setName("测试数据Update");
        book.setDescription("测试数据Update");
        book.setType("测试数据Update");
        bookDao.updateById(book);
    }
    @Test
    void testDelete(){
        bookDao.deleteById(22);
    }
    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }
    @Test
    void testGetPage(){

    }
    @Test
    void testGet(){

    }
}

