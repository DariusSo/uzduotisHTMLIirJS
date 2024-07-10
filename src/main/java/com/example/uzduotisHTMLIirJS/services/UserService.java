package com.example.uzduotisHTMLIirJS.services;

import com.example.uzduotisHTMLIirJS.models.User;
import com.example.uzduotisHTMLIirJS.repositories.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class UserService {
    public void addUser(User u) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        ur.addUser(u);
    }

    UserRepository ur = new UserRepository();
    public String getJwtToken(String username, String password) throws SQLException {
        return ur.getJwtToken(username, password);
    }
    public String getJwtTokenModifyDelete(String username, String password) throws SQLException {
        return ur.getJwtTokenModifyDelete(username, password);
    }
}
