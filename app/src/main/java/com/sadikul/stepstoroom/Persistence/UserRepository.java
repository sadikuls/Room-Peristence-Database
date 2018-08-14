package com.sadikul.stepstoroom.Persistence;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.sadikul.stepstoroom.Persistence.Dao.UserDao;
import com.sadikul.stepstoroom.Persistence.User_Table.User;

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
