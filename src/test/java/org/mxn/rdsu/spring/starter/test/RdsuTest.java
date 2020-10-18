package org.mxn.rdsu.spring.starter.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mxn.rdsu.spring.starter.test.entity.Product;
import org.mxn.rdsu.spring.starter.test.entity.User;
import org.mxn.rdsu.spring.starter.util.RdsuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RdsuTest {
    @Autowired
    RdsuUtil rdsuUtil;

    @Test
    public void getOps(){
        String key = "rdsu";
        rdsuUtil.set(key,new User("mxn",3));
        User user = rdsuUtil.get(key, User.class);
        System.out.println(user);
    }

    @Test
    public void listOps(){
        String key = "rdsu-list";
        rdsuUtil.lPush(key,new User("mxn",3));
        rdsuUtil.lPush(key,new User("hy",1));
        User item = rdsuUtil.lIndex(key, 0, User.class);
        System.out.println(item);
        List<User> users = rdsuUtil.lRange(key, 0, -1, User.class);
        System.out.println(users);
    }

    @Test
    public void mapOps(){
        String key = "rdsu-map";
        rdsuUtil.hSet(key,"mxn",new User("mxn",3));
        rdsuUtil.hSet(key,"hy",new User("hy",4));
        rdsuUtil.hSet(key,"2233",new Product("2233","face mask",100));
        rdsuUtil.hSet(key,"6677",new Product("6677","sport shoe",200));

        User user = rdsuUtil.hGet(key, "hy", User.class);
        System.out.println(user);
        Product product = rdsuUtil.hGet(key, "2233", Product.class);
        System.out.println(product);
    }

    @Test
    public void setOps(){
        String key = "rdsu-set";
        rdsuUtil.sAdd(key,new User("mxn",3),new User("hy",4));
        Set<User> users = rdsuUtil.sMembers(key, User.class);
        System.out.println(users);
    }
}
