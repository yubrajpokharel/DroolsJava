package com.yubraj.drools;

import com.yubraj.drools.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ypokhrel on 7/25/2017.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ((ProductService)applicationContext.getBean("ProductServiceImpl")).runProductLogic();
        ((ProductService)applicationContext.getBean("NoRulesProductServiceImpl")).runProductLogic();
    }
}
