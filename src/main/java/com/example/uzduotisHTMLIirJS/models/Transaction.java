package com.example.uzduotisHTMLIirJS.models;

public class Transaction {
    int id;
    String endpoint;
    String requestContent;
    int userId;

    public Transaction(int id, String endpoint, String requestContent, int userId) {
        this.id = id;
        this.endpoint = endpoint;
        this.requestContent = requestContent;
        this.userId = userId;
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
