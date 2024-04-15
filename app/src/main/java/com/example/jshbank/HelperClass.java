package com.example.jshbank;

public class HelperClass {
    String name , email, username, password, ph_no;


    public HelperClass() {
    }

    public HelperClass(String name, String email, String username, String password, String ph_no) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.ph_no = ph_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
}
