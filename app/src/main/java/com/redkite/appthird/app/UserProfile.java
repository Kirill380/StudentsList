package com.redkite.appthird.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.redkite.appthird.app.mock.StudentRepository;
import com.redkite.appthird.app.model.Student;


public class UserProfile extends Activity  {

//    TODO find out better solution
    private String login;
    private StudentRepository repo = new StudentRepository();
    private ImageView photo;
    private TextView fullName;
    private TextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        login = getIntent().getStringExtra("login");

        photo = (ImageView) findViewById(R.id.photo);
        fullName = (TextView) findViewById(R.id.full_name);
        description = (TextView) findViewById(R.id.descrition);


        Student s = repo.getStudentByLogin(login);

        photo.setImageResource(s.getPhoto());
        fullName.setText(s.getLastName() + " " + s.getFirstName() + " " + s.getMiddleName());
        description.setText(s.getDescription());
    }


    public void goToMainPage(View view) {
        Intent intent = new Intent(this, WelcomePage.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }
}
