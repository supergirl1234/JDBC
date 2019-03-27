package com;

import java.sql.Timestamp;

/**
 * Author:Fanleilei
 * Created:2019/3/26 0026
 */
public class MemoGroup2 {
    private int id;
    private String name;
    private Timestamp created_time;
    private Timestamp modify_time;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_time(Timestamp created_time) {
        this.created_time = created_time;
    }

    public void setModify_time(Timestamp modify_time) {
        this.modify_time = modify_time;
    }

    @Override
    public String toString() {
        return "MemoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_time=" + created_time +
                ", modify_time=" + modify_time +
                '}';
    }
}
