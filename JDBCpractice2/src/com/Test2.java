package com;





import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/3/27 0027
 */
public class Test2 {
    public  static JdbcTemplate2 jdbcTemplate2=new JdbcTemplate2();

    public static void queryByName(String name){
        String sql = "select id ,name,created_time, modify_time  from memo_group  where name='" + name + "'";

        List<MemoGroup2> list=jdbcTemplate2.execute(sql,new ResultSetHandler());
        if(list!=null) {
            for (MemoGroup2 t : list) {
                System.out.println(t);

            }
        }
    }

    public static void main(String[] args) {
        queryByName("Java新组");


    }
}

class ResultSetHandler implements Handler<ResultSet,List<MemoGroup2>> {


    @Override
    public List<MemoGroup2> handler(ResultSet resultSet) {

        List<MemoGroup2> list=new ArrayList<>();

        try {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");

                String name = resultSet.getString("name");
                Timestamp created_time = resultSet.getTimestamp("created_time");
                Timestamp modify_time = resultSet.getTimestamp("modify_time");
                MemoGroup2 memoGroup2 = new MemoGroup2();
                memoGroup2.setId(id);
                memoGroup2.setName(name);
                memoGroup2.setCreated_time(created_time);
                memoGroup2.setModify_time(modify_time);
                list.add(memoGroup2);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
