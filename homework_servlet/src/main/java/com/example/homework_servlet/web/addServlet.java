package com.example.homework_servlet.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.homework_servlet.entity.User;
import com.example.homework_servlet.service.AddService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class addServlet extends HttpServlet {



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader br=req.getReader();
        String jsonStr="";//从前端来的字符串类型的数据
        String tmp=null;
        while ((tmp= br.readLine())!=null){
            jsonStr += tmp;
        }
        System.out.println("jsonstr:"+jsonStr);
        JSONObject params= (JSONObject) JSON.parse(jsonStr);
        //接受参数
        String num=(String)params.get("num");
        String uname=(String)params.get("uname");
        String gender=(String)params.get("gender");
        String age=(String)params.get("age");
        String job=(String)params.get("job");
        String salary=(String)params.get("salary");
        //处理登录逻辑
        String result="fail";

        User u=new User(num,uname,gender,age,job,salary);
        System.out.println(u.toString());
        AddService addService=new AddService();
        int r=addService.send(u);
        System.out.println("r::"+r);
        if(r>0){
            result="ok";
        }
        System.out.println("result::"+result);
        //返回数据
        JSONObject data=new JSONObject();
        data.put("result",result);
        PrintWriter pw=resp.getWriter();
        pw.print(data.toJSONString());
        pw.flush();
        pw.close();
    }
}
