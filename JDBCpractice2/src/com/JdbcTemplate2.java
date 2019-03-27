package com;

import java.sql.*;

/**
 * Author:Fanleilei
 * Created:2019/3/26 0026
 */
public class JdbcTemplate2 {

    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;

    //1.加载驱动程序

    public void Loader(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.建立数据库连接
    public void GetConnection(){

        String url="jdbc:mysql://127.0.0.1:3306/memo";
        try {
           connection= DriverManager.getConnection(url,"root","mysql0205");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.创建命令
    public void CreateStatement(){
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //6.关闭资源

    public void closeResource() {
        //结果 -> 命令 -> 连接
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public final <T,R> R execute(String sql,Handler<T,R> handler){

        this.Loader();
        this.GetConnection();
        this.CreateStatement();
        try {
            if (sql.trim().startsWith("s")||sql.trim().startsWith("S")){


                    resultSet=statement.executeQuery(sql);
                    return handler.handler((T) resultSet);

            }else {
                Integer effect=statement.executeUpdate(sql);
                return handler.handler((T)effect);

                }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{

            this.closeResource();
        }
        return null;


    }
}


 interface Handler<T,R>{

    R handler(T t);
}