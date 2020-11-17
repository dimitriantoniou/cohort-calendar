package com.edimitri.cohortcalendar.models;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(nullable=false,length=50,unique=true)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false,columnDefinition="boolean default false")
    private boolean isAdmin;


    public User(){ }//empty constructor

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public User(int id, String username, String email, String firstName, String lastName, String password, boolean isAdmin) {
        //this();
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email = email;
        this.username=username;
        this.password=password;
        this.isAdmin=isAdmin;
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

    public long getUserId() {
        return id;
    }

    public void setUserId(int userId) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

