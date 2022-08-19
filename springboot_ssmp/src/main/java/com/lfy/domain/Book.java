package com.lfy.domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//注入set get 构造 方法
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
