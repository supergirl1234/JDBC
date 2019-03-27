package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/3/26 0026
 */
public class Test1  extends JdbcTemplate1{



    @Override
    public String providerSql() {
        return "select id,name,created_time,modify_time from memo_group";
    }

    @Override
    public <T> T handler(ResultSet resultSet) {
        //把结果保存在一个集合里面
        List<MemoGroup> list = new ArrayList<>();
        try{
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
               Timestamp created_time= resultSet.getTimestamp("created_time");
               Timestamp modify_time= resultSet.getTimestamp("modify_time");

                MemoGroup memoGroup=new MemoGroup(id,name,created_time, modify_time);
                list.add(memoGroup);
            }
        }catch(SQLException e){
        e.getStackTrace();

        }

        return (T) list;
    }

    public static void main(String[] args) {

        JdbcTemplate1 p=new Test1();
        List<MemoGroup> list = p.execute();
        for(MemoGroup t:list){
            System.out.println(t);

        }

    }
}
