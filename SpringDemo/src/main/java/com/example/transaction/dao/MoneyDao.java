package com.example.transaction.dao;

public interface MoneyDao {
    void IncrementMoney(Double money,String name);

    void DecrementMoney(Double money,String name);
}
