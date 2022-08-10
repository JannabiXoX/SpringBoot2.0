package com.lfy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lfy.domain.Book;
import com.lfy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    public IBookService iBookService;

    @GetMapping
    public List<Book> getAll(){
        return iBookService.list();
    }

    @PostMapping
    public boolean save(@RequestBody Book book){
        return iBookService.save(book);
    }

    @PutMapping
    public boolean update(@RequestBody Book book){
        return iBookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public boolean remove(@PathVariable Book id){
        return iBookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return  iBookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return iBookService.getPage(currentPage,pageSize, null);
    }
}
