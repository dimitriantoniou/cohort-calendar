package com.edimitri.cohortcalendar.models;


public class User {

    private int userId;

    private static int nextId=1;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean isAdmin;


    public User(int id, String email, String firstName, String lastName, String password, boolean isAdmin) {
        this();
        this.userId=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email = email;
        this.password=password;
        this.isAdmin=isAdmin;
    }
    public User(){
        userId=nextId;
        nextId++;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

