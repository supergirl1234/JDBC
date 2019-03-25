package com.p2;

import java.sql.*;

/**
 * Author:Fanleilei
 * Created:2019/3/25 0025
 */
public class TestJdbcTemplate2 {

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
    public  void CreateSql(){};


    //5.处理结果集
    public  void  Hander1(ResultSet resultSet){};

    public  void  Hander2(int effect){};


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
            if(sql.trim().startsWith("s") || sql.trim().startsWith("S")){

                resultSet=this.statement.executeQuery(sql);
                this.Hander1(resultSet);

            }else{
                int effect = this.statement.executeUpdate(sql);
                this.Hander2(effect);

                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
    }
}
