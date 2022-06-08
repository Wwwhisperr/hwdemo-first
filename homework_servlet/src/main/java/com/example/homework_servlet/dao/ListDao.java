package com.example.homework_servlet.dao;

import com.example.homework_servlet.entity.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListDao {

    public List<User> selectAll(){
        List<User> list=new ArrayList<>();
        Connection con=null;
        try {
            //连接数据库
            String url="jdbc:mysql://localhost:3306/vuehw";
            String u="root";
            String p="a123";
            String sql="select *from vuesql ";
            new Driver();
             con= DriverManager.getConnection(url,u,p);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                //获取全部信息
                User user=new User();
                user.setNum(rs.getString("num"));
                user.setUname(rs.getString("uname"));
                user.setGender(rs.getString("gender"));
                user.setAge(rs.getString("age"));
                user.setJob(rs.getString("job"));
                user.setSalary(rs.getString("salary"));
                list.add(user);
                System.out.println(user.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception e){}
        }
        return list;
    }
}
