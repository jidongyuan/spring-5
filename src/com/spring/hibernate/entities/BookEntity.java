package com.spring.hibernate.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2017-01-04.
 */
@Entity
@Table(name = "book", schema = "", catalog = "jdy")
public class BookEntity {
    private int id;
    private String isbn;
    private String bookname;
    private int price;

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
    @Column(name = "bookname")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (bookname != null ? !bookname.equals(that.bookname) : that.bookname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (bookname != null ? bookname.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
