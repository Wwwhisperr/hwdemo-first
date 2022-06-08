package com.example.homework_servlet.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String num;
    private String uname;
    private String gender;
    private String age;
    private String job;
    private String salary;
}
