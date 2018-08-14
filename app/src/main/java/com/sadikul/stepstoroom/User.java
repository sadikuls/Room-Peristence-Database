package com.sadikul.stepstoroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "username")
    private String userName;

    @ColumnInfo(name = "email")
    private String userEmail;

    public int getId() {
        return uid;
    }

    public void setId(int id) {
        this.uid = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
