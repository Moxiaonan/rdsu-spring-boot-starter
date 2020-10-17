package org.mxn.rdsu.spring.starter.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.rdsu.spring.starter.util.RdsuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RdsuTest {
    @Autowired
    RdsuUtil rdsuUtil;

    @Test
    public void getOps(){
//        String rdsu = rdsuUtil.get("rdsu",String.class);
//        System.out.println(rdsu);
    }
}
