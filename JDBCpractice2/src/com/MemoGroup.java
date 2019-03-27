package com;

import java.sql.Timestamp;

/**
 * Author:Fanleilei
 * Created:2019/3/26 0026
 */
public class MemoGroup {
    private int id;
    private String name;
    private Timestamp created_time;
    private Timestamp modify_time;

    public MemoGroup(int id, String name, Timestamp created_time, Timestamp modify_time) {
        this.id = id;
        this.name = name;
        this.created_time = created_time;
        this.modify_time=modify_time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreated_time() {
        return created_time;
    }

    public Timestamp getModify_time() {
        return modify_time;
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
