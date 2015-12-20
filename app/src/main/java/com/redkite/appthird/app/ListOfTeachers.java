package com.redkite.appthird.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ListOfTeachers extends Activity {

    private String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        login = getIntent().getStringExtra("login");
    }


    public void goToMainPage(View view) {
        Intent intent = new Intent(this, WelcomePage.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }
}
