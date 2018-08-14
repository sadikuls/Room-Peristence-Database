package com.sadikul.stepstoroom.Activities;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sadikul.stepstoroom.Adapters.UserAdapter;
import com.sadikul.stepstoroom.R;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView = null;
    UserAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(this);
        recyclerView.setAdapter(adapter);



    }
}
