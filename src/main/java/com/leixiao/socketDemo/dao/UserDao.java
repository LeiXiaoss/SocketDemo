package com.leixiao.socketDemo.dao;

import com.leixiao.socketDemo.entiy.User;
import com.leixiao.socketDemo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    private static String sql1 = "insert into users values(null,?,?)";
    private static String sql2 = "select password from users where username=?";

    private static Connection connection=null;
    private static PreparedStatement statement=null;

    //注册
    public int register(User user){
        int line = 0;

        try{
            connection = DBUtil.getConnection();
            statement=connection.prepareStatement(sql1);

            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());

            line=statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.release(connection,statement,null);
        }

        return line;
    }

    //登陆校验
    public String validate(String username){
        String password = null;
        ResultSet resultSet = null;

        try{
            connection = DBUtil.getConnection();
            statement=connection.prepareStatement(sql2);

            statement.setString(1,username);

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                password = resultSet.getString("password");
            }

            System.out.println("username:"+username+",password"+password);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.release(connection,statement,resultSet);
        }
        return password;
    }
}
