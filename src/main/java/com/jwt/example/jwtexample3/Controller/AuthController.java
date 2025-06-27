package com.jwt.example.jwtexample3.Controller;

import com.jwt.example.jwtexample3.model.JwtRequest;
import com.jwt.example.jwtexample3.model.JwtResponse;
import com.jwt.example.jwtexample3.security.JwtHelper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")

public class AuthController {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    //private Logger logger= (Logger) LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
   public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getEmail(),request.getPassword());

        UserDetails userDetails=userDetailsService.loadUserByUsername(request.getEmail());
        String token=this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .token(token)
                .username(userDetails.getUsername())
                .build();
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    private void doAuthenticate(String email, String password) {
    }


}
