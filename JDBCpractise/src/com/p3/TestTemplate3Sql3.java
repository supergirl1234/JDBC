package com.p3;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/3/25 0025
 */
public class TestTemplate3Sql3 extends TestJdbcTemplate3 {


    public  void CreateSql(){
        sql="select id,name,created_time from memo_group;";

    }



    public  <T> void  Handler(ResultSet resultSet){
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

    public  <T> void  Handler(int effect){
        System.out.println("影响的行数："+effect);
    }



    public static void main(String[] args) {
        TestJdbcTemplate3 p3=new TestTemplate3Sql3();
        p3.Process();

    }
}
