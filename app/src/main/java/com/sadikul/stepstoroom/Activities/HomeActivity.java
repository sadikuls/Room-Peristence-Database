package com.sadikul.stepstoroom.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import static com.sadikul.stepstoroom.Utils.Constants.EXTRA_EMAIL;
import static com.sadikul.stepstoroom.Utils.Constants.EXTRA_NAME;
import static com.sadikul.stepstoroom.Utils.Constants.NEW_USER_ACTIVITY_REQUEST_CODE;

import com.sadikul.stepstoroom.Adapters.UserAdapter;
import com.sadikul.stepstoroom.R;
import com.sadikul.stepstoroom.Persistence.User_Table.User;
import com.sadikul.stepstoroom.Persistence.ViewModel.UserViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView = null;
    FloatingActionButton floatingActionButton;
    UserAdapter adapter = null;
    UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        floatingActionButton = findViewById(R.id.fab);
        mUserViewModel =  ViewModelProviders.of(this).get(UserViewModel.class);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(this);
        recyclerView.setAdapter(adapter);

        mUserViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable final List<User> users) {
                // Update the cached copy of the words in the adapter.
                adapter.setUsers(users);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddNewUserActivity.class);
                startActivityForResult(intent, NEW_USER_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_USER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            User user = new User(data.getStringExtra(EXTRA_NAME),data.getStringExtra(EXTRA_EMAIL));
            mUserViewModel.insert(user);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
