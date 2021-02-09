package it.academy.impl;

import it.academy.UserService;
import it.academy.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserDto findUser(String login, String password) {
        return null;
    }
}
