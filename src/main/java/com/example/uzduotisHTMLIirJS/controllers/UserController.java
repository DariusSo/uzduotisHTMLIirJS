package com.example.uzduotisHTMLIirJS.controllers;

import com.example.uzduotisHTMLIirJS.models.User;
import com.example.uzduotisHTMLIirJS.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

@RestController
public class UserController {
    UserService us = new UserService();

    @CrossOrigin
    @PostMapping("/addUser")
    public void addUser(@RequestBody User u) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        us.addUser(u);
    }
    @CrossOrigin
    @GetMapping("/getToken")
    public String getJwtToken(String username, String password) throws SQLException {
        return us.getJwtToken(username, password);
    }
    @CrossOrigin
    @GetMapping("/getTokenModifyDelete")
    public String getJwtTokenModifyDelete(String username, String password) throws SQLException {
        return us.getJwtTokenModifyDelete(username, password);
    }
}
