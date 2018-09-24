package com.example.user.pizzadelivery;

public class User {
    private String Username;
    private int Password;
    private String Email;
    private String Address;
    private String NoPhone;

    public String getUsername(){
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public int getPassword(){
        return Password;
    }

    public void setPassword(int password) {
        this.Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getNoPhone() {
        return NoPhone;
    }

    public void setNoPhone(String noPhone) {
        this.NoPhone = noPhone;
    }
}
