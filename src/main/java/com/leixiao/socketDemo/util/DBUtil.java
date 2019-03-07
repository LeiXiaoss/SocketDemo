package com.leixiao.socketDemo.util;


import java.sql.*;

public class DBUtil {

    private static String driver="com.mysql.jdbc.driver";
    private static String url="jdbc:mysql://127.0.0.1:3306/" +
            "register?useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";
    private static String password = "123";

    //注册数据库驱动
    static {
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //释放连接
    public static void release(Connection connection,
                               Statement statement, ResultSet resultSet){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
