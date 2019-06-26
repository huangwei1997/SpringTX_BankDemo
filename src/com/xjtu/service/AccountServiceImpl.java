package com.xjtu.service;

import com.xjtu.mapper.AccountMapper;
import com.xjtu.pojo.Account;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
   @Resource
    private AccountMapper accountMapper;
   //校验转账用户信息
    @Override
    public Account checkOutAccount(int aid, String apwd) {
        return accountMapper.getAccountByIdPwd(aid,apwd);
    }
    //校验转账金额
    @Override
    public Account checkOutMoney(int aid, String apwd, double money) {
        return accountMapper.getAccountByIdPwdMoney(aid,apwd,money);
    }
    //校验入账用户信息
    @Override
    public Account checkInAccount(int aid, String aname) {
        return accountMapper.getAccountByIdName(aid,aname);
    }
    //转账
    @Override
    public int transferAccountService(int outId, int inId, double money) {
        //转账
        int i = accountMapper.transferAccount(outId,-money);
        //入账
        i+= accountMapper.transferAccount(inId,money);
        return i;
    }
}
