package com.redkite.appthird.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.redkite.appthird.app.mock.StudentRepository;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class ListOfStudents extends Activity {

    private String login;
    private StudentRepository repo = new StudentRepository();

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);


        CustomListAdapter adapter = new CustomListAdapter(this,
                repo.getNames(),
                repo.getPhotos(),
                repo.getDescriptions());

        list = (ListView) findViewById(R.id.students);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String selectedItem = repo.getNames()[+position];
                makeText(getApplicationContext(), selectedItem, LENGTH_SHORT).show();

            }
        });


        login = getIntent().getStringExtra("login");

    }

    public void goToMainPage(View view) {
        Intent intent = new Intent(this, WelcomePage.class);
        intent.putExtra("login", login);
        startActivity(intent);
    }
}
