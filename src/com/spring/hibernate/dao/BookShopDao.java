package com.spring.hibernate.dao;

/**
 * Created by Administrator on 2016-12-12.
 */
public interface BookShopDao {

    /*������Ż�ȡ��ĵ���*/
    public int findBookPriceByIsbn(String isbn);

    /*������Ŀ�棬ʹ��Ŷ�Ӧ�Ŀ��-1*/
    public void updateBookStock(String isbn);

    /*�����û��˻���ʹusername��balance - price*/
    public void updateUserAccount(String username, int price);
}
