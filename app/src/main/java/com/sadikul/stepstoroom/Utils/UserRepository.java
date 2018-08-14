package com.sadikul.stepstoroom.Utils;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.sadikul.stepstoroom.User;
import com.sadikul.stepstoroom.UserDao;

import java.util.List;

public class UserRepository {

    UserDao mUserDao;
    LiveData<List<User>> allUser;

    //initialize user repository
    public UserRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        mUserDao = appDatabase.userDao();
        allUser = mUserDao.getAll();
    }

    //get all users
    public LiveData<List<User>> getAllUsers() {
        return allUser;
    }

    //insert user via asynctask
    public void insert (User user) {
        new insertAsyncTask(mUserDao).execute(user);
    }

    public class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insertUser(params[0]);
            return null;
        }
    }



}
