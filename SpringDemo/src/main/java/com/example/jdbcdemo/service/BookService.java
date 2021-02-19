package com.example.jdbcdemo.service;

import com.example.jdbcdemo.dao.BookDao;
import com.example.jdbcdemo.entity.Book;
import org.springframework.stereotype.Service;


public interface BookService  {
    public void addBook(Book book);
}
