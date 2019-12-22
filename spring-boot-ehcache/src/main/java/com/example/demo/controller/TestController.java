package com.example.demo.controller;

import com.example.demo.entity.User;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    @Qualifier("custom")
    private Ehcache ehcache;

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        User user = new User();
        user.setName("ouyang");
        user.setAge(12);
        Element element = new Element("user1", user);
        ehcache.put(element);

        User user2 = new User();
        user2.setName("shuguang");
        user2.setAge(15);
        Element element2 = new Element("user2", user2);
        ehcache.put(element2);
        return "test1";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {
        User user3 = new User();
        user3.setName("oy");
        user3.setAge(16);
        Element element = new Element("user3", user3);
        ehcache.put(element);

        User user4 = new User();
        user4.setName("sg");
        user4.setAge(18);
        Element element2 = new Element("user4", user4);
        ehcache.put(element2);
        return "test1";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3() {
        User user = new User();
        user.setName("ouyang");
        user.setAge(12);
        Element element = new Element("user1", user);
        ehcache.put(element);
        return "test1";
    }
}
