package com.auth;

import java.security.Principal;

class UserPrincipal implements Principal{
    String name;
    public UserPrincipal(String name) {
        super();
        this.name = name;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

}