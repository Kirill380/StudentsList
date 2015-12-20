package com.redkite.appthird.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class WelcomePage extends Activity {

    private EditText loginField;
    private EditText passField;
    private TextView textLogin;
    private TextView textPass;
    private Button loginBtn;
    private Button profile;
    private Button listStudents;
    private Button listTeachers;
    private String login;
    //    TODO work around make up new design
    private final int LOG_OUT_TOP_MARGIN = 20;
    private final int LOG_IN_TOP_MARGIN = 40;
    private final int WIDTH_OF_LARGE_BUTTON = 300;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginField = (EditText) findViewById(R.id.login);
        passField = (EditText) findViewById(R.id.pass);
        profile = (Button) findViewById(R.id.profile);
        loginBtn = (Button) findViewById(R.id.login_btn);
        listStudents = (Button) findViewById(R.id.students);
        listTeachers = (Button) findViewById(R.id.teachers);
        textLogin = (TextView) findViewById(R.id.lable_login);
        textPass = (TextView) findViewById(R.id.lable_pass);


        login = getIntent().getStringExtra("login");
        if(login == null || login.length() == 0) {
            enableButtons(false);
            toggleLogIn(false);
        }
        else {
            toggleLogIn(true);
        }
    }



    public void goToProfile(View view) {
        Intent intent = new Intent(this, UserProfile.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goToStudentList(View view) {
        Intent intent = new Intent(this, ListOfStudents.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }

    public void goToTeacherList(View view) {
        Intent intent = new Intent(this, ListOfTeachers.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }


    public void logIn(View view) {
        //TODO check if user exist
        login = loginField.getText().toString();
        enableButtons(true);
        toggleLogIn(true);

    }


    public void logOut(View view) {
        loginField.setText("");
        passField.setText("");
        enableButtons(false);
        toggleLogIn(false);
    }

    private void toggleLogIn(boolean toggle) {
        RelativeLayout.LayoutParams layoutParam = (RelativeLayout.LayoutParams) loginBtn.getLayoutParams();
        if(toggle) {
            loginField.setVisibility(View.GONE);
            passField.setVisibility(View.GONE);
            textLogin.setVisibility(View.GONE);
            textPass.setVisibility(View.GONE);
            loginBtn.setText("Log out");
            layoutParam.topMargin = LOG_OUT_TOP_MARGIN;
            loginBtn.setLayoutParams(layoutParam);
            loginBtn.setWidth(dpToPx(WIDTH_OF_LARGE_BUTTON));
            loginBtn.setBackgroundResource(R.drawable.campus_logout_button);
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logOut(v);
                }
            });
        } else {
            loginField.setVisibility(View.VISIBLE);
            passField.setVisibility(View.VISIBLE);
            textLogin.setVisibility(View.VISIBLE);
            textPass.setVisibility(View.VISIBLE);
            loginBtn.setText("Log in");
            layoutParam.topMargin = LOG_IN_TOP_MARGIN;
            loginBtn.setWidth(dpToPx(WIDTH_OF_LARGE_BUTTON/2));
            loginBtn.setLayoutParams(layoutParam);
            loginBtn.setBackgroundResource(R.drawable.campus_login_button);
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logIn(v);
                }
            });
        }
    }

    private void enableButtons(boolean enable) {
        listStudents.setEnabled(enable);
        listTeachers.setEnabled(enable);
        profile.setEnabled(enable);
        profile.getBackground().setAlpha(enable ? 255 : 127);
        listStudents.getBackground().setAlpha(enable ? 255 : 127);
        listTeachers.getBackground().setAlpha(enable ? 255 : 127);
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }


}
