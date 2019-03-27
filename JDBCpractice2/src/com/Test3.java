package com;

import java.sql.ResultSet;
import java.util.List;

/**
 * Author:Fanleilei
 * Created:2019/3/27 0027
 */
public class Test3 {

    public  static JdbcTemplate3 p=new JdbcTemplate3();
    public static  void queryName(String name){
        String sql="select id,name,created_time,modify_time from memo_group where name in (?)";


        List<MemoGroup2> list=p.execute(sql, new String[]{name}, (Handler<ResultSet, List<MemoGroup2>>) new ResultSetHandler());
       if(list!=null){

           for(MemoGroup2 t:list){
               System.out.println(t);

           }
       }

    }

    public static void main(String[] args) {
       queryName("Java新组");



        System.out.println("-----------");
        /**
         * 预编译命令
         * 1. 赋值参数，下标 1开始，防止SQL注入
         * 2. in 如果？不能传入多个参数
         * 3. 效率比较高
         * 4. 推荐使用预编译命令
         */

       // queryName("'Java新组','PHP组'");//所以查询不出来


    }
}
