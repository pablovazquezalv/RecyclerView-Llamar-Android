package com.example.recyclewviewllamar;

public class Usuario {
    private String username;
    private String Phone;

    public String getPhone()
    {
        return Phone;
    }

    public void setPhone(String phone)
    {
        Phone = phone;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario(String username, String Phone) {
        this.username = username;
        this.Phone = Phone;
    }
}
