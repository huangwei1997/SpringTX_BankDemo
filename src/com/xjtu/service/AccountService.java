package com.xjtu.service;

import com.xjtu.pojo.Account;

public interface AccountService {
    //校验转账账户信息
    Account checkOutAccount(int aid, String apwd);
    //校验转账账户余额
    Account checkOutMoney(int aid , String apwd, double money);
    //校验入账账户信息
    Account checkInAccount(int aid ,String aname);
    //转账
    int transferAccountService(int outId,int inId,double money);
}
