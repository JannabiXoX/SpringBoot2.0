package com.lfy;

import com.lfy.config.MsgConfig;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
//@Import(MsgConfig.class)
public class ConfigurationTest {
    @Autowired
    private String msg;

    @Test
    void testConfiguration(){
        System.out.println(msg);
    }
}
