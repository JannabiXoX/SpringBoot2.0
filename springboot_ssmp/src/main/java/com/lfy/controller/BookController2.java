package com.lfy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lfy.controller.util.R;
import com.lfy.domain.Book;
import com.lfy.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public R save(@RequestBody Book book) throws IOException {
        if(book.getName().equals("123")) throw new IOException();
        boolean flag =  iBookService.save(book);
        return new R(flag,flag ? "添加成功！" : "添加失败");

    }

    @PutMapping
    public R update(@RequestBody Book book){
        boolean flag =  iBookService.updateById(book);
        return new R(flag,flag ? "修改成功！" : "修改失败");
    }

    @DeleteMapping("{id}")
    public R remove(@PathVariable Integer id){

        return new R(iBookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){

        return new R(true,iBookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page = iBookService.getPage(currentPage,pageSize);
//        if (currentPage > page.getPages()){
//            page = iBookService.getPage((int)page.getPages(),pageSize);
//        }
//        return new R(true,page);
//    }
@GetMapping("{currentPage}/{pageSize}")
public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
    IPage<Book> page = iBookService.getPage(currentPage,pageSize,book);
    if (currentPage > page.getPages()){
        page = iBookService.getPage((int)page.getPages(),pageSize,book);
    }
    return new R(true,page);
}
}
