package com.example.jdbcdemo.dao.impl;

import com.example.jdbcdemo.dao.BookDao;
import com.example.jdbcdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBook(Book book) {

        String sql="insert into book_info values(?,?)";
        int res = jdbcTemplate.update(sql, book.getBookId(), book.getBookName());
        System.out.println(res);
    }
}
