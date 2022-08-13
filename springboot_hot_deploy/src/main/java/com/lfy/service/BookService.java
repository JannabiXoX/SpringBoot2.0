package com.lfy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfy.domain.Book;

public interface BookService extends IService<Book> {
    boolean saveBook(Book book);
    boolean delete(Integer id);
    boolean modify(Book book);
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
