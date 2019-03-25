package com.p2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/3/25 0025
 */
public class TestTemplate2Sql2  extends TestJdbcTemplate2{

    public  void CreateSql(){
        sql="select id,name,created_time from memo_group;";
    };



    public  void  Hander1(ResultSet resultSet){
        try {
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                LocalDateTime created_time=resultSet.getTimestamp("created_time").toLocalDateTime();
                System.out.println(String.format("id=%d,name=%s,created_time=%s",id,name,created_time.toString()));

            }
        }catch (SQLException e){

            e.getStackTrace();
        }
    }




    public static void main(String[] args) {
        TestJdbcTemplate2 p2=new TestTemplate2Sql2();
        p2.Process();

    }
}
