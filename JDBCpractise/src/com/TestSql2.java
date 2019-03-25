package com;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/3/25 0025
 */
public class TestSql2 {



    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset=null;
        //1.加载数据库驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.建立数据库连接
        String url="jdbc:mysql://localhost:3306/memo";
        try {
            connection=DriverManager.getConnection(url,"root","mysql0205");
            statement=connection.createStatement();

            //4.执行sql语句
            String sql="insert into memo_group values(6,'C++组','2019-3-25 19:40:26','2019-3-25 19:40:26')";

             //增删改用statement.executeUpdate（）
           int count =statement.executeUpdate(sql);

            //5.处理结果集

                System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally{

            //6.关闭结果集、操作命令、数据库连接
            if(resultset!=null){

                resultset.close();
            }

            if(statement!=null){

                statement.close();
            }
            if(connection!=null){

                connection.close();
            }
        }
    }

}
