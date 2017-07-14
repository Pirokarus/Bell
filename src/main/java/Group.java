package main.java;

import java.io.Serializable;

public class Group implements Serializable{

    private static int id_count;
    private int id;
    private String name;

    {
        id = id_count;
        ++id_count;
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Индекс: " + id +
                "Название: " + name + '\'' +
                "\n";
    }
}
