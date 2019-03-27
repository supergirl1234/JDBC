package com;

import java.sql.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Author:Fanleilei
 * Created:2019/3/25 0025
 */
public abstract class JdbcTemplate1 {

    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;

    //1.加载驱动程序
    public void Load(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.连接数据库
    public  void getConnection(){

        String url="jdbc:mysql://127.0.0.1:3306/memo";
        try {
            connection=DriverManager.getConnection(url,"root","mysql0205");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.创建命令
    public void createStatement(){

        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        //4.SQL语句
        public abstract String  providerSql();

        //5.处理结果
        public <T> T handler(ResultSet resultSet){

            return null;
        }

        public <T> T handler(int effect){

            return null;
        }

        //6.关闭资源
        public void closeResource(){

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
    public final <T> T execute(){

            this.Load();
            this.getConnection();
            this.createStatement();
            String sql=this.providerSql();
            try {
                if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {

                        resultSet = this.statement.executeQuery(sql);

                    return this.handler(resultSet);
                } else {
                    int effect = this.statement.executeUpdate(sql);
                    return this.handler(effect);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                this.closeResource();

        }

            return null;
    }


}

