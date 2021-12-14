package com.example.andrey_exam_prep.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotBlank
    @Size(min = 2, message = "Username must be more than 2 characters!")
    private String username;
    @NotBlank
    @Size(min = 2, message = "Password must be more than 2 characters!")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
