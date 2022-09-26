package com.janglabs.todolistserver.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {
    @Getter
    public static class SignUp {
        private String email;
        private String password;
        private String name;
    }

    @Getter
    public static class SignIn {
        private String email;
        private String password;
    }

    @Getter
    public static class Update {
        private Long id;
        private String password;
        private String name;
    }
}
