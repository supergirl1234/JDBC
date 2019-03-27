package com;

import java.sql.*;

/**
 * Author:Fanleilei
 * Created:2019/3/27 0027
 *
 * 事务控制
 */
public class Jdbc4 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url="jdbc:mysql://127.0.0.1:3306/memo";

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
           connection=DriverManager.getConnection(url,"root","mysql0205");
           //事务控制
            connection.setAutoCommit(false);

           statement=connection.createStatement();
           String sql1="insert into memo_group values(3,'GO组', '2019-03-24 10:15:00','2019-03-27 23:01:00')";
           int inserteffect=statement.executeUpdate(sql1);
            System.out.println("插入数据："+inserteffect);


            String sql2="update memo_group set name='Python组'where id=5";
            int updateEffect=statement.executeUpdate(sql2);
            System.out.println("更新数据："+updateEffect);

            if(inserteffect==1&&updateEffect==1) {
                connection.commit();
            }else{

               connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if(connection!=null){

                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        }finally{
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


    }
}
