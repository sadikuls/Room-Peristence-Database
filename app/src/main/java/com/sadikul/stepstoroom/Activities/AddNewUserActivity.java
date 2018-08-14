package com.sadikul.stepstoroom.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sadikul.stepstoroom.R;

import static com.sadikul.stepstoroom.Utils.Constants.EXTRA_EMAIL;
import static com.sadikul.stepstoroom.Utils.Constants.EXTRA_NAME;

public class AddNewUserActivity extends AppCompatActivity {

    private EditText mEditNameView;
    private EditText mEditEmailView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);
        mEditNameView = findViewById(R.id.edit_name);
        mEditEmailView = findViewById(R.id.edit_email);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditNameView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String name = mEditNameView.getText().toString();
                    String email = mEditEmailView.getText().toString();
                    replyIntent.putExtra(EXTRA_NAME, name);
                    replyIntent.putExtra(EXTRA_EMAIL, email);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
