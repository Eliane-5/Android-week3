package com.moringaschool.craftypictures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.startButton) Button mStartButton;
    @BindView(R.id.nameEditText) EditText mUserNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mUserNameEditText.getText().toString();
                addToSharedPreferences(userName);
                Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
    }
    private void addToSharedPreferences(String userName) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, userName).apply();
    }
}
