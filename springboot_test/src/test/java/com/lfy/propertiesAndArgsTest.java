package com.lfy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//properties属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties = {"test.prop=testValue1"})
//args属性可以为当前测试用例添加临时的命令行数据
//@SpringBootTest(args = {"--test.prop=testValue2"})
@SpringBootTest(properties = {"test.prop=testValue1"},args = {"--test.prop=testValue2"})
public class propertiesAndArgsTest {
    @Value("${test.prop}")
    private String msg;
    @Test
    void testProperties(){
        System.out.println(msg);
    }
}
