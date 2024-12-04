package org.zidioschool.services;

import org.zidioschool.model.UserDAO;
import org.zidioschool.model.modelClasses.User;

public class Login {
    private UserDAO userDAO;

    public Login() {
        this.userDAO = new UserDAO();
    }

    public boolean authenticate(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}