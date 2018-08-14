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
    @Query("SELECT * FROM User")
    LiveData<List<User>> getAll();

    //get all user from database by userid
    @Query("SELECT * FROM User WHERE uid IN (:userIds)")
    List<User> getUserByIds(int[] userIds);


    //get specific user from database by username and email
    @Query("SELECT * FROM User WHERE username LIKE :name AND email LIKE :email LIMIT 1")
    User findByNameAndEmail(String name ,String email);

    //insert all users to database
    @Insert
    void insertAll(User... users);
    //insert all users to database


    @Delete
    void deleteAll();

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

}
