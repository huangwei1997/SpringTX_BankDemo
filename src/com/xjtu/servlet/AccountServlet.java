package com.xjtu.servlet;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountServlet extends HttpServlet {
    private DecideMethod decideMethod;
    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        decideMethod = (DecideMethod) ac.getBean("decideMethod");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求响应格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取操作符,判断调用哪个方法
        String oper = req.getParameter("oper");
        if("out".equals(oper)){
            decideMethod.outAccount(req,resp);
        }else if("in".equals(oper)){
            decideMethod.inAccount(req,resp);
        }else if("money".equals(oper)){
            decideMethod.outMoney(req,resp);
        }else if("transfer".equals(oper)){
            decideMethod.transferAccount(req,resp);
        }else {
            System.out.println("没有找到对应的操作符:" + oper);
        }

    }



}
