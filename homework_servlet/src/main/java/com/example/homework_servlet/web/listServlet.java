package com.example.homework_servlet.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.homework_servlet.entity.User;
import com.example.homework_servlet.service.findlistService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class listServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader br=req.getReader();
        String jsonStr="";
        String tmp=null;
        while ((tmp=br.readLine())!=null){
            jsonStr+=tmp;
        }
        System.out.println("add jsonstr:"+jsonStr);
        JSONObject params= (JSONObject) JSON.parse(jsonStr);
        //业务逻辑
        List<User> list=new ArrayList<>();
        String result="fail";
        if (params!=null){
            findlistService fls=new findlistService();
            list=fls.findall();
            result="ok";
        }
        //返回数据
        resp.setContentType("application/json;charset=utf-8");
        JSONObject data=new JSONObject();
        data.put("result",result);
        data.put("data",list);
        PrintWriter pw=resp.getWriter();
        pw.print(data.toJSONString());
        pw.flush();
        pw.close();






    }
}
