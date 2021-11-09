package com.example.blogpagestage;

import com.example.blogpagestage.tool.UserTool;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogPageStageApplicationTests {

    @Autowired
    UserTool userTool;

    @Test
    void contextLoads() {
//        String uuid = userTool.getUUID();
//        System.out.println(uuid);
    }

}
