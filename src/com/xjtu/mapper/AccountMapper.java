package com.xjtu.mapper;

import com.xjtu.pojo.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {
    //根据转账账户ID和密码获取账户信息
    @Select("select * from account where aid =#{0} and apwd=#{1}")
    Account getAccountByIdPwd(int aid,String apwd);
    //根据转账账户id和密码和转账金额获取账户信息
    @Select("select * from account where aid =#{0} and apwd=#{1} and money>=#{2}")
    Account getAccountByIdPwdMoney(int aid ,String apwd , double money);
    //根据入账账户id和账户名称获取账户信息
    @Select("select * from account where aid =#{0} and aname=#{1}")
    Account getAccountByIdName(int aid,String name);
    //转账
    @Update("update account set money=money+#{1} where aid=#{0}")
    int transferAccount(int aid ,double money);
}
