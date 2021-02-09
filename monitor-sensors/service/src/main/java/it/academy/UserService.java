package it.academy;

import it.academy.dto.UserDto;

public interface UserService {

    UserDto findUser(String login, String password);

}
