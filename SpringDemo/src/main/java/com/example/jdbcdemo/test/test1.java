package com.example.jdbcdemo.test;

import com.example.jdbcdemo.entity.Book;
import com.example.jdbcdemo.service.BookService;
import com.example.jdbcdemo.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {

    @Test
    public void test01(){
        ApplicationContext context=new  ClassPathXmlApplicationContext("bean05.xml");
        BookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);
        Book book=new Book();
        book.setBookId(2);
        book.setBookName("钢铁少女");
        bookService.addBook(book);
    }
}
