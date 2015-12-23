package com.redkite.appthird.app.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Kirill Liubun on 20/12/2015.
 */
public class Person {
    protected String login;
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected String pass;
    protected int photo;
    private String description;


    public Person() {

    }
    public Person(String login, String firstName, String lastName, String middleName, String pass, int photo, String description) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.pass= pass;
        this.photo = photo;
        this.description = description;
    }

    public boolean isEmpty() {
        return StringUtils.isEmpty(login) || StringUtils.isEmpty(pass);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
