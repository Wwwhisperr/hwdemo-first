package com.example.homework_servlet.service;

import com.example.homework_servlet.dao.ListDao;
import com.example.homework_servlet.entity.User;
//业务逻辑层
import java.util.List;

public class findlistService {

    public List<User> findall(){
        List<User> list;
        ListDao ld=new ListDao();
        list=ld.selectAll();
        return list;
    }

}
