package com.movieFlix.mapper;

import com.movieFlix.controller.request.UserRequest;
import com.movieFlix.controller.response.UserResponse;
import com.movieFlix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User toUser (UserRequest userRequest){
        return User
                .builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public UserResponse toUserResponse(User user){
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
