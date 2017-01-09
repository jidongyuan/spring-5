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
     * spring hibernate���������
     * 1.�ڷ���֮ǰ��
     * ��.��ȡsession
     * ��.��session�͵�ǰ�̰߳󶨣������Ϳ�����dao��ʹ��sessionFactory��getCurrentSession()��������ȡsession
     * ��.��������
     *
     * 2.������������������û�г����쳣����
     * ��.�ύ����
     * ��.ʹ�͵�ǰ�̰߳󶨵�session�����
     * ��.�ر�session
     *
     * 3.�����������쳣����
     * ��.�ع�����
     * ��.ʹ�͵�ǰ�̰߳󶨵�session�����
     * ��.�ر�session
     *
     * */
    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username,price);
    }
}
