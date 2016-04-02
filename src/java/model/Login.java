/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import utility.Utils;

/**
 *
 * @author brad
 */
public class Login {
    private String user;
    private String pass;
    private Boolean isLoggedIn;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
    public String doLogin() {
        String passhash = Utils.hash(pass);
        for (User u : new Users().getUsers()) {
            if (user.equals(u.getEmail())
                    && passhash.equals(u.getPasshash())) {
                isLoggedIn = true;
                return "Logged In";
            }
        }
        isLoggedIn = false;
        return "Logged Out";
    }
}
