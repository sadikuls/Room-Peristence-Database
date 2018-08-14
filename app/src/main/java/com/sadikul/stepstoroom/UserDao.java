package com.sadikul.stepstoroom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    //get all user from database
    @Query("SELECT * FROM User ORDER BY username ASC")
    LiveData<List<User>> getAll();


    //insert all users to database
    @Insert
    void insertAll(User... users);
    //insert all users to database

    @Insert
    void insertUser(User user);


    @Query("DELETE FROM User")
    void deleteAll();


}
