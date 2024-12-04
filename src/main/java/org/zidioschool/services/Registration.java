package org.zidioschool.services;

import org.zidioschool.model.UserDAO;
import org.zidioschool.model.modelClasses.User;

public class Registration {
    private UserDAO userDAO;

    public Registration() {
        this.userDAO = new UserDAO();
    }

    public boolean register(String email, String password, int teacherId) {
        if (userDAO.getUserByUsername(email) != null) {
            return false; // User already exists
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setTeacherId(teacherId);
        userDAO.addUser(user);
        return true;
    }
}