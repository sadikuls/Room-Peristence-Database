package com.sadikul.stepstoroom.Utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sadikul.stepstoroom.User;
import com.sadikul.stepstoroom.UserDao;

/*created room database by extending RoomDatabase class . This is an abstract class that contains
abstract method that will return dao object
*/
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
