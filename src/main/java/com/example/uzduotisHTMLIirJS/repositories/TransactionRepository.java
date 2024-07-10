package com.example.uzduotisHTMLIirJS.repositories;

import com.example.uzduotisHTMLIirJS.utils.Connect;
import io.jsonwebtoken.Claims;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionRepository {
    public static void registerTransactions(Claims claims, String endpoint, String request) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO transactions (endpoint, request_content, user_id) VALUES (?,?,?)");
        ps.setString(1, endpoint);
        ps.setString(2, request);
        ps.setString(3, String.valueOf(claims.get("UserId")));
        ps.execute();
    }
    public static void registerTransactions(String endpoint, String request) throws SQLException {
        PreparedStatement ps = Connect.SQLConnection("INSERT INTO transactions (endpoint, request_content) VALUES (?,?)");
        ps.setString(1, endpoint);
        ps.setString(2, request);
        ps.execute();
    }
}
