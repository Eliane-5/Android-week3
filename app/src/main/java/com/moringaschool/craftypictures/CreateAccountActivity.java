package com.moringaschool.craftypictures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = CreateAccountActivity.class.getSimpleName();

    @BindView(R.id.userNameTextView) TextView mUserNameTextView;
    @BindView(R.id.backToLoginTextView) TextView mBackToLoginTextView;
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.enterEmailEditText) EditText mEnterEmailEditText;
    @BindView(R.id.enterPasswordEditText) EditText mEnterPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

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
            createNewUser();
        }
    }

    private void createNewUser() {
        final String name = mUserNameTextView.getText().toString().trim();
        final String email = mEnterEmailEditText.getText().toString().trim();
        String password = mEnterPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                        } else {
                            Toast.makeText(CreateAccountActivity.this, "please verify if you have inputted correct email and password with at least 6 characters!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
