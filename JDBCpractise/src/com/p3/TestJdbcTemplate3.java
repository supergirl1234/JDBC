package com.p3;

import java.sql.*;

/**
 * Author:Fanleilei
 * Created:2019/3/25 0025
 */
public  class TestJdbcTemplate3 {

    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;
    String sql=null;
    //1.驱动器加载
    public  void Load(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //2.数据库连接
    public  void Getconnection(){

        String url="jdbc:mysql://localhost:3306/memo";

        try {
            connection=DriverManager.getConnection(url,"root","mysql0205");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.创建命令
    public  void  CreateStatement(){

        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //4.处理SQL语句
    public void CreateSql(){};


    //5.处理结果集
    public  <T> void Handler( ResultSet resultSet){};
    public  <T> void Handler(int effect){};

    //public  <T> void Handler(T t){};这种写法不行，这样写的话，在实现类中，覆写不起作用；要把它写成一个接口，在实现类中才能起作用，


    //6.关闭结果集、操作命令、数据库连接
    public void close(){

        if(resultSet!=null){
            try {
                resultSet.close();
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
        if(connection!=null){

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public  void Process(){
        this.Load();
        this.Getconnection();
        this.CreateStatement();
        this.CreateSql();
        try {
            if(sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")){

                resultSet=statement.executeQuery(sql);
                this.Handler(resultSet);

            }else{
                int effect = statement.executeUpdate(sql);
                this.Handler(effect);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }
}
