package Akme.controller;

import Akme.model.ProductModel;
import Akme.model.UserModel;
import Akme.view.LoginView;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private List<UserModel> userModels;
    private LoginView loginView;

    public LoginController( LoginView loginView) {
        this.userModels = new ArrayList<>();
        this.loginView = loginView;
    }
    public void AddUser(UserModel userModel){
        userModels.add(userModel);
    }
    public boolean authenticateUser() {
        while (true) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();


            if (findUserName(username)) {
                if(findPassword(password)) {
                    loginView.showLoginSuccessMessage();
                    return true;
                }
            } else {
                loginView.showLoginErrorMessage();
            }
        }
    }
    public boolean authenticateUserG(String username,String password) {

        if (findUserName(username)) {
            if(findPassword(password)) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    private boolean findUserName(String name) {
        for (UserModel userModel1 : userModels) {
            if (userModel1.getUsername().equals(name)) {
                return true;
            }
        }
        return false;
    }
    private boolean findPassword(String password) {
        for (UserModel userModel1 : userModels) {
            if (userModel1.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public UserModel findUser(String password) {
        for (UserModel userModel1 : userModels) {
            if (userModel1.getPassword().equals(password)) {
                return userModel1;
            }
        }
        return null;
    }
}
