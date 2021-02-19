package com.example.transaction.service.impl;

import com.example.transaction.dao.MoneyDao;
import com.example.transaction.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneyDao moneyDao;


    //模拟事务操作
    public void MoneyOperation(String name1,String name2, Double money) {

        //try {
            //开启事务
            moneyDao.IncrementMoney(money,name1);
            //模拟异常
            int i=1/0;
            moneyDao.DecrementMoney(money,name2);
        //} catch (Exception e) {
            //存在异常,事务回滚
        //}

    }
}
