package com.sadikul.stepstoroom.Persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sadikul.stepstoroom.Persistence.User_Table.User;

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
