package com.spring.hibernate.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-01-04.
 */
@Entity
@Table(name = "book_stock", schema = "", catalog = "jdy")
public class BookStockEntity {
    private int id;
    private String isbn;
    private int stock;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "stock")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookStockEntity that = (BookStockEntity) o;

        if (id != that.id) return false;
        if (stock != that.stock) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + stock;
        return result;
    }
}
