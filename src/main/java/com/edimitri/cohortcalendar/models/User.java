package com.edimitri.cohortcalendar.models;

public class User {
    public String firstName;
    public String lastName;
    public String email;
    private String password;
    private int userId;
    private static int nextId=1;

    public User(String email, String firstName, String lastName) {
        this();
        this.email = email;
        this.firstName=firstName;
        this.lastName=lastName;
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
}
