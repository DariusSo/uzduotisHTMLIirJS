package com.example.uzduotisHTMLIirJS.repositories;

import com.example.uzduotisHTMLIirJS.models.User;
import com.example.uzduotisHTMLIirJS.utils.Connect;
import com.example.uzduotisHTMLIirJS.utils.JwtGenerator;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class UserRepository {
    public void addUser(User u) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
//        SecureRandom random = new SecureRandom();
//        byte[] salt = new byte[16];
//        random.nextBytes(salt);
//        KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
//        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//        byte[] hash = f.generateSecret(spec).getEncoded();
//        Base64.Encoder enc = Base64.getEncoder();
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO users (username, password) VALUES (?,?)");
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.execute();
    }
    public String getJwtToken(String username, String password) throws SQLException {
        String token = "";
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM users WHERE username = ? AND password = ? LIMIT 1");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            token = JwtGenerator.generateJwt(rs.getString("username"), rs.getString("password"), rs.getInt("id"));
            return token;
        }
        return "Wrong username or password";
    }
    public String getJwtTokenModifyDelete(String username, String password) throws SQLException {
        String token = "";
        PreparedStatement ps = Connect.SQLConnection("SELECT * FROM users WHERE username = ? AND password = ? LIMIT 1");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            token = JwtGenerator.generateJwtModifyDelete(rs.getString("username"), rs.getString("password"), rs.getInt("id"));
            return token;
        }
        return "Wrong username or password";
    }
}
