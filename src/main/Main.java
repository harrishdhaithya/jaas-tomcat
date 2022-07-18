package main;
import java.util.Scanner;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import com.auth.AuthCallbackHandler;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Name: ");
        String name = in.nextLine();
        System.out.println("Enter your Password: ");
        String password = in.nextLine();
        AuthCallbackHandler ac = new AuthCallbackHandler(name, password);
        try {
            LoginContext lc = new LoginContext("authtest", ac);
            lc.login();
            System.out.println("Login Successfull...");
        } catch (LoginException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Login Failed...");
        }
        in.close();
    }    
}
