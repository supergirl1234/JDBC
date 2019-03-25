package com.p1;

import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/3/25 0025
 */
public class TestTemplateSql1 extends TestJdbcTemplate {
    @Override
    public void CreateSql() {
         sql="select id,name,created_time,modify_time from memo_group";
    }

    @Override
    public void Hander() {
        try {
            resultSet=statement.executeQuery(sql);

            while (resultSet.next()) {

                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                LocalDateTime created_time=resultSet.getTimestamp("created_time").toLocalDateTime();
                System.out.println(String.format("id=%d,name=%s,created_time=%s",id,name,created_time.toString()));
            }
        }catch (SQLException e ){
            e.getStackTrace();

        }
    }

    public static void main(String[] args) {
        TestJdbcTemplate p1=new TestTemplateSql1();
        p1.Process();
    }
}
