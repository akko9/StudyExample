package com.example.jdbcdemo.service.impl;

import com.example.jdbcdemo.dao.BookDao;
import com.example.jdbcdemo.entity.Book;
import com.example.jdbcdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    public void addBook(Book book) {
        bookDao.addBook(book);
    }
}
