package it.academy.dto;

import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserDto extends EntityDto {

    private String login;

    private String password;

    private String role;


}
