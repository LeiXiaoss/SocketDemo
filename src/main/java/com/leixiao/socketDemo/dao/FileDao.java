package com.leixiao.socketDemo.dao;

import com.leixiao.socketDemo.entiy.File;
import com.leixiao.socketDemo.util.DBUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FileDao {
    //将文件保存到数据库中
    private String sql = "insert into phote values(null,?,?)";
    private static Connection connection;
    private static PreparedStatement statement;

    public int update(File file){
        int line = 0;
        try{
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);

            //写入sql语句的参数
            statement.setString(1,file.getfName());

            //将字节数组转为输入流
            InputStream is = new ByteArrayInputStream(file.getfContent());
            statement.setBlob(2,is);

            //执行调用
            line = statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.release(connection,statement,null);
        }

        return line;
    }
}
