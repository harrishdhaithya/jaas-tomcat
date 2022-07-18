package com.auth;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class AuthCallbackHandler implements CallbackHandler {
    private String user = null;
    private String password = null;
    
    public AuthCallbackHandler(String user, String password) {
        super();
        this.user = user;
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for(int i=0;i<callbacks.length;i++){
            if(callbacks[i] instanceof NameCallback){
                NameCallback ncb = (NameCallback)callbacks[i];
                ncb.setName(user);
            }else if(callbacks[i] instanceof PasswordCallback){
                PasswordCallback pcb = (PasswordCallback)callbacks[i];
                pcb.setPassword(password.toCharArray());
            }
        }
    }
    
}
