package com.lfy.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestTask {
    @Autowired
    private IBookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setName("测试数据");
        book.setDescription("测试数据");
        book.setType("测试数据");
        bookService.saveBook(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(21);
        book.setName("测试数据Update");
        book.setDescription("测试数据Update");
        book.setType("测试数据Update");
        bookService.updateById(book);
    }
    @Test
    void testDelete(){
        bookService.removeById(22);
    }
    @Test
    void testGetAll(){
        bookService.list();
    }
    @Test
    void testGetPage(){
//        IPage page = bookService.getPage(2,5);
        IPage<Book> page = new Page<Book>(2,5);
        IPage<Book> page1 = bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
