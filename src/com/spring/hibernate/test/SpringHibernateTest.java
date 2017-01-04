package com.spring.hibernate.test;

import com.spring.hibernate.service.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016-12-27.
 */
public class SpringHibernateTest {
    private ApplicationContext ctx = null;
    private BookShopService bookShopService = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopService = ctx.getBean(BookShopService.class);
    }

    @Test
    public void test() throws SQLException{
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testBookShopService(){
        bookShopService.purchase("aa","1001");
    }
}
