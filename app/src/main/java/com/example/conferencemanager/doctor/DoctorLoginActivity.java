package com.example.conferencemanager.doctor;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conferencemanager.R;

public class DoctorLoginActivity extends AppCompatActivity {

    private Context mContext;
    //the edit texts
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    //the button used
    private Button mLogInButton;
    //the error textviews
    private TextView mUsernameError;
    private TextView mPasswordError;
    //generic error message
    private String EMPTY_FIELD_ERROR = "";
    //test user and password
    private final String TEST_USERNAME = "doctor123";
    private final String TEST_PASSWORD = "doctorpass123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mContext = getApplicationContext();
        EMPTY_FIELD_ERROR = getResources().getString(R.string.no_input);
        loadUiElements();
        setOnClickListeners();
    }

    /******************************* START OF UI METHODS******************************/
    private void loadUiElements() {
        //the edittext views
        mUsernameEditText = (EditText) findViewById(R.id.doctor_login_username_value);
        mPasswordEditText = (EditText) findViewById(R.id.doctor_login_password_value);
        //the buttons
        mLogInButton = (Button) findViewById(R.id.doctor_login_button);
        //the error fields
        mUsernameError = (TextView) findViewById(R.id.doctor_login_username_error);
        mPasswordError = (TextView) findViewById(R.id.doctor_login_password_error);
    }
    /*******************************END OF UI METHODS******************************/

    /****************************START OF onClick METHODS****************************/
    private void setOnClickListeners() {
        mLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDoctorCredentials();
            }
        });

    }

    /****************************END OF onClick METHODS****************************/

    /*****************************START OF CHECK METHODS*****************************/

    private boolean checkUsernameField() {
        if (mUsernameEditText.getText().toString().length() == 0) {
            mUsernameError.setVisibility(View.VISIBLE);
            mUsernameError.setText(EMPTY_FIELD_ERROR);
            mUsernameEditText.getBackground().setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
            //cancelLogInDialog();
            return false;
        }
        else {
            if (mUsernameError.getVisibility() == View.VISIBLE) {
                mUsernameError.setVisibility(View.INVISIBLE);
                mUsernameError.setText("");
                mUsernameEditText.getBackground().setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
                return true;
            }
        }
        return true;
    }

    private boolean checkPasswordField() {
        if (mPasswordEditText.getText().toString().length() == 0) {
            mPasswordError.setVisibility(View.VISIBLE);
            mPasswordError.setText(EMPTY_FIELD_ERROR);
            mPasswordEditText.getBackground().setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
            //cancelLogInDialog();
            return false;
        }
        else {
            if (mPasswordError.getVisibility() == View.VISIBLE) {
                mPasswordError.setVisibility(View.INVISIBLE);
                mPasswordError.setText("");
                mPasswordEditText.getBackground().setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
                return true;
            }
        }
        return true;
    }

    private void checkDoctorCredentials() {
        if (checkUsernameField() && checkPasswordField()) {
            if (!(mUsernameEditText.getText().toString().equals(TEST_USERNAME) || mPasswordEditText.getText().equals(TEST_PASSWORD))) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DoctorLoginActivity.this);
                builder.setMessage(R.string.invalid_login)
                        .setTitle(R.string.generic_error_occurred)
                        .setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else
                logInDoctor();

        }
        else {
            if (!checkUsernameField()) {
                //intentionally blank
            }
            if (!checkPasswordField()) {
                //intentionally blank
            }
        }
    }
    private void logInDoctor() {
        Toast.makeText(mContext, "Ready to log in", Toast.LENGTH_SHORT).show();
    }
    /*****************************END OF CHECK METHODS*****************************/

}
