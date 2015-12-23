package com.redkite.appthird.app.model;

/**
 * Created by Kirill Liubun on 20/12/2015.
 */
public class Teacher extends Person {
    private String link;

    public Teacher() {

    }

    public Teacher(String login, String firstName, String lastName, String middleName, String pass, int photo, String description) {
        super(login, firstName, lastName, middleName, pass, photo, description);
    }
}
