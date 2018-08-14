package com.sadikul.stepstoroom.Persistence.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.sadikul.stepstoroom.Persistence.User_Table.User;
import com.sadikul.stepstoroom.Persistence.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel{
    UserRepository mRepository = null;

    LiveData<List<User>> allUser;

    public UserViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        allUser = mRepository.getAllUsers();
    }

    //get all users
    public LiveData<List<User>> getAllUsers() {
        return allUser;
    }

    //insert user
    public void insert (User user) {
        mRepository.insert(user);
    }
}
