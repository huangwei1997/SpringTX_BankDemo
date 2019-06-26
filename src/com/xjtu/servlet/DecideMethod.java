package com.xjtu.servlet;

import com.xjtu.pojo.Account;
import com.xjtu.service.AccountService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DecideMethod {
    @Resource
    private AccountService accountService;

    //转账
    public void transferAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        int outId  = Integer.parseInt(req.getParameter("outId"));
        int inId = Integer.parseInt(req.getParameter("inId"));
        double money = Double.parseDouble(req.getParameter("money"));
        //处理请求信息
        int i = accountService.transferAccountService(outId,inId,money);
        //响应请求信息
        if(i==2){
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }
    //校验转账金额
    public void outMoney(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        int outId = Integer.parseInt(req.getParameter("outId"));
        String outPwd = req.getParameter("outPwd");
        double money = Double.parseDouble(req.getParameter("money"));
        //处理请求信息
        Account account = accountService.checkOutMoney(outId,outPwd,money);
        //响应请求信息
        if(account!=null){
            resp.getWriter().write("true");
        }else{
            resp.getWriter().write("false");
        }
    }
    //校验入账账户信息
    public void inAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        int inId = Integer.parseInt(req.getParameter("inId"));
        String inName = req.getParameter("inName");
        //处理请求信息
        Account account = accountService.checkInAccount(inId,inName);
        //响应请求信息
        if(account!=null){
            resp.getWriter().write("true");
        }else{
            resp.getWriter().write("false");
        }
    }
    //校验转账账户信息
    public void outAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取请求信息
        int outId = Integer.parseInt(req.getParameter("outId"));
        String outPwd = req.getParameter("outPwd");
        //处理请求信息
        Account account =  accountService.checkOutAccount(outId,outPwd);
        //响应请求信息
        if(account!=null){
            resp.getWriter().write("true");
        }else{
            resp.getWriter().write("false");
        }
    }

}
