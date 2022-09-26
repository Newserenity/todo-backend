package com.janglabs.todolistserver.user.controller;

import com.janglabs.todolistserver.security.JwtDto;
import com.janglabs.todolistserver.user.domain.UserEntity;
import com.janglabs.todolistserver.user.dto.UserDto;
import com.janglabs.todolistserver.user.service.AuthService;
import com.janglabs.todolistserver.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.RescaleOp;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<UserEntity> singUp(@RequestBody UserDto.SignUp req) {
        return new ResponseEntity<>(userService.singUp(req), HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JwtDto> singIn(@RequestBody UserDto.SignIn req) {
        return new ResponseEntity<>(authService.signIn(req), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> detail(@PathVariable Long id ) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserEntity> update(@RequestBody UserDto.Update req) {
        return new ResponseEntity<>(userService.update(req), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> softDelete(@PathVariable Long id) {
        return new ResponseEntity<>(userService.softDelete(id), HttpStatus.OK);
    }
}
