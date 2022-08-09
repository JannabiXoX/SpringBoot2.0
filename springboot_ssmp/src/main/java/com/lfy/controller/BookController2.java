package com.lfy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lfy.controller.util.R;
import com.lfy.domain.Book;
import com.lfy.service.BookService;
import com.lfy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    public IBookService iBookService;

    @GetMapping
    public R getAll(){
        return new R(true,iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){

        return new R(iBookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){

        return new R(iBookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R remove(@PathVariable Integer id){

        return new R(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){

        return new R(true,iBookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return new R(true,iBookService.getPage(currentPage,pageSize));
    }
}
