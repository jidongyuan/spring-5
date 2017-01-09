package com.spring.hibernate.test;

import com.spring.hibernate.service.BookShopService;
import com.spring.hibernate.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016-12-27.
 */
public class SpringHibernateTest {
    private ApplicationContext ctx = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }


    @Test
    public void test() throws SQLException{
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testCashier(){
        cashier.checkout("aa", Arrays.asList("1001","1002"));
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("aa","1001");
    }
}
