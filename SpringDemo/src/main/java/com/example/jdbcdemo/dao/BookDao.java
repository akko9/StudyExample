package com.example.jdbcdemo.dao;

import com.example.jdbcdemo.entity.Book;
import org.springframework.stereotype.Repository;


public interface BookDao {
    public void addBook(Book book);

}
