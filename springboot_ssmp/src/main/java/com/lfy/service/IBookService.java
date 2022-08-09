package com.lfy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfy.domain.Book;

public interface IBookService extends IService<Book> {
    boolean saveBook(Book book);
    boolean delete(Integer id);
    boolean modify(Book book);
    IPage<Book> getPage(int currentPage,int pageSize);
}
