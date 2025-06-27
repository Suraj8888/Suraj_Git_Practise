package com.jwt.example.jwtexample3.model;

import lombok.*;


public class JwtResponse {

    private String token;

    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JwtResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }

    public JwtResponse() {
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public static class Builder {
        private String token;
        private String username;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(token, username);
        }
    }

    // Static method to access builder
    public static Builder builder() {
        return new Builder();
    }
}




