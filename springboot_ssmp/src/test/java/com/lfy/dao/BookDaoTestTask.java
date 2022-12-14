package com.lfy.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        bookDao.selectList(null);
    }
    @Test
    void testGetPage(){
        IPage page = new Page(2,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
    //条件查询
    @Test
    void testGetBy(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","C++");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetByLambda(){
        String name = null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        if (name != null){
//            queryWrapper.like(Book::getName,name);
//        }
        lambdaQueryWrapper.like(name != null,Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);
    }
}

