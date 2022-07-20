package service;

import java.io.IOException;
import java.security.Principal;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.auth.AuthCallbackHandler;

public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        AuthCallbackHandler cb = new AuthCallbackHandler(name, password);
        try {
            LoginContext lc = new LoginContext("authtest",cb);
            lc.login();
            Subject s = lc.getSubject();
            for(Principal p:s.getPrincipals()){
                resp.getWriter().println(p);
            }
            resp.getWriter().println("login success...");
        } catch (LoginException e) {
            resp.getWriter().println(e);
        }
        resp.getWriter().println(name+" "+password);
    }
}
