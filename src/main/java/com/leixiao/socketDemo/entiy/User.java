package com.leixiao.socketDemo.entiy;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 7590687781985776082L;

    private String id;
    private String username;
    private String password;

    public User(){}

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
