package com.example.homework_servlet.dao;

import com.example.homework_servlet.entity.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddDao {
    public int insert(User u){
        Connection con = null;
        int r=-1;
        try {
            //连接数据库
            String url="jdbc:mysql://localhost:3306/vuehw";
            String ue="root";
            String p="a123";
            String sql="insert into vuesql(num,uname,gender,age,job,salary) values (?,?,?,?,?,?)";
            new Driver();
             con = DriverManager.getConnection(url,ue,p);
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,u.getNum());
            ps.setString(2, u.getUname());
            ps.setString(3,u.getGender());
            ps.setString(4,u.getAge());
            ps.setString(5,u.getJob());
            ps.setString(6,u.getSalary());
            r=ps.executeUpdate();//返回影响行数

            System.out.println("add成功了吗：："+r);
        }catch (Exception e){
            e.printStackTrace();
            r=-1;
        }finally {
            try {
                con.close();
            }catch (Exception e){}
        }
        return r;
    }
}
