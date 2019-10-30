package com.example.zoy.firebasereal;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Query_class {
    private String name;
    private String id;
    private String email;

    public Query_class() {


    }

    public Query_class(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}