package com.jwt.example.jwtexample3.services;

import com.jwt.example.jwtexample3.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(),"Suraj Bhete","suraj@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Manoj Bhete","Manoj@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Kedar Bhete","Kedar@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Shubham Bhete","Shubham@gmail.com"));

    }

    public List<User> getUsers(){

        return this.store;
    }
}
