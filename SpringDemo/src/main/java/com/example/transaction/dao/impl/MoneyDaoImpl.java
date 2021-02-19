package com.example.transaction.dao.impl;

import com.example.transaction.dao.MoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyDaoImpl implements MoneyDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void IncrementMoney(Double money,String name) {
        String sql="update money_info set money=money+? where username=? ";
        int update = jdbcTemplate.update(sql, money,name);
        System.out.println(update);
    }

    public void DecrementMoney(Double money,String name) {
        String sql="update money_info set money=money-? where username=? ";
        int update = jdbcTemplate.update(sql, money,name);
        System.out.println(update);
    }
}
