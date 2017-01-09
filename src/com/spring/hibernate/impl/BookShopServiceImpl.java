package com.spring.hibernate.impl;

import com.spring.hibernate.dao.BookShopDao;
import com.spring.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-01-03.
 */
@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * spring hibernate事务的流程
     * 1.在方法之前：
     * ①.获取session
     * ②.把session和当前线程绑定，这样就可以在dao中使用sessionFactory的getCurrentSession()方法来获取session
     * ③.开启事务
     *
     * 2.若方法正常结束，即没有出现异常，则
     * ①.提交事务
     * ②.使和当前线程绑定的session解除绑定
     * ③.关闭session
     *
     * 3.若方法出现异常，则
     * ①.回滚事务
     * ②.使和当前线程绑定的session解除绑定
     * ③.关闭session
     *
     * */
    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username,price);
    }
}
