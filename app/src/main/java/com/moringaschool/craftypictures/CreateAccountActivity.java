package com.moringaschool.craftypictures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.backToLoginTextView) TextView mBackToLoginTextView;
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.enterEmailEditText) EditText mEnterEmailEditText;
    @BindView(R.id.enterPasswordEditText) EditText mEnterPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        mBackToLoginTextView.setOnClickListener(this);
        mCreateUserButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mBackToLoginTextView) {
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if (v == mCreateUserButton) {
//            createNewUser();
        }
    }
}
