package com.movieFlix.controller;

import com.movieFlix.config.TokenService;
import com.movieFlix.controller.request.LoginRequest;
import com.movieFlix.controller.request.UserRequest;
import com.movieFlix.controller.response.LoginResponse;
import com.movieFlix.controller.response.UserResponse;
import com.movieFlix.entity.User;
import com.movieFlix.mapper.UserMapper;
import com.movieFlix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "V1/movieflix/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest user){

        User result = userService.save(UserMapper.toUser(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(result));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest login){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(login.email(), login.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();

        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));

    }

}
