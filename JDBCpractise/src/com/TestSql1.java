package com;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/3/24 0024
 */
public class TestSql1 {


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

            //4.执行sql语句  select 语句
           String sql="select id,name,created_time from memo_group";



            //3.创建操作命令  查询语句用statement.executeQuery（）
                resultset=statement.executeQuery(sql);

            //5.处理结果集
            while(resultset.next()){
                int id=resultset.getInt("id");
                String name=resultset.getString("name");
                LocalDateTime created_time=resultset.getTimestamp("created_time").toLocalDateTime();
                System.out.println(String.format("id=%d,name=%s,created_time=%s",id,name,created_time.toString()));


            }
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
