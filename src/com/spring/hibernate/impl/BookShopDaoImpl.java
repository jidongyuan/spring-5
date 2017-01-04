package com.spring.hibernate.impl;

import com.spring.hibernate.dao.BookShopDao;
import com.spring.hibernate.exception.BookStockException;
import com.spring.hibernate.exception.UserAccountException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.management.Query;

/**
 * Created by Administrator on 2017-01-03.
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private SessionFactory sessionFactory;

    //���Ƽ�ʹ��hibernateTemplate��hibernateDaoSupport
    //��Ϊ�����ᵼ��dao��spring��api�������
    //����ֲ�Ա��
    //private HibernateTemplate hibernateTemplate; // org.springframework.orm.hibernate3.HibernateTemplate �������

    /*��ȡ�͵�ǰ�̰߳󶨵�session*/
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String hql = "select b.price from BookEntity b where b.isbn = ?";
        org.hibernate.Query query = getSession().createQuery(hql).setString(0,isbn);
        return Integer.valueOf(query.uniqueResult().toString());
    }

    @Override
    public void updateBookStock(String isbn) {
        //��֤��Ŀ���Ƿ����
        String hql2 = "select b.stock from BookStockEntity b where b.isbn = ?";
        int stock = Integer.valueOf(getSession().createQuery(hql2).setString(0, isbn).uniqueResult().toString());
        if(stock == 0){
            throw new BookStockException("��治�㣡");
        }
        String hql = "update BookStockEntity b set b.stock = b.stock - 1 where isbn = ?";
        getSession().createQuery(hql).setString(0,isbn).executeUpdate();
    }

    @Override
    public void updateUserAccount(String username, int price) {
        //��֤����Ƿ��㹻
        String hql2 = "select a.balance from AccountEntity  a where a.username = ?";
        int blance = Integer.valueOf(getSession().createQuery(hql2).setString(0, username).uniqueResult().toString());
        if(blance < price){
            throw new UserAccountException("���㣡");
        }
        String hql = "update AccountEntity a set a.balance = a.balance - ? where a.username = ?";
        getSession().createQuery(hql).setInteger(0,price).setString(1,username).executeUpdate();
    }
}
