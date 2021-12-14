package com.example.andrey_exam_prep.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String username;
    private boolean isAnonymous;



    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }


    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isAnonymous() {
        return this.id==null;
    }

    public CurrentUser setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
        return this;
    }
}
