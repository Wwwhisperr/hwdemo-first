package com.example.homework_servlet.service;

import com.example.homework_servlet.dao.AddDao;
import com.example.homework_servlet.entity.User;
//业务逻辑层
public class AddService {

    public int send(User u){
        AddDao addDao=new AddDao();
        int r= addDao.insert(u);
        System.out.println("service r::"+r);
        return r;
    }

}
