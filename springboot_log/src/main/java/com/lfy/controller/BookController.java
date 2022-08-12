package com.lfy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    //创建记录日志的对象
//    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String getById(){
        System.out.printf("springboot is running...\n");

        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        return "springboot is running...";
    }
}
