package com.weboniselab.meghana.android.app.recyclerandcardview;

/**
 * Created by webonise on 9/10/15.
 */
public class Model {
    int id;
    String name,age;

    public Model(){
        this.id=0;
        this.name="";
        this.age="";
    }

    public Model(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
