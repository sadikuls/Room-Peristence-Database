package com.sadikul.stepstoroom.Persistence.User_Table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int uid;

    @ColumnInfo(name = "username")
    private String userName;

    @ColumnInfo(name = "email")
    private String userEmail;

    public User(String userName,String userEmail){
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int id) {
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
