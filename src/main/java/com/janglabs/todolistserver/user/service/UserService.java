package com.janglabs.todolistserver.user.service;

import com.janglabs.todolistserver.user.domain.UserEntity;
import com.janglabs.todolistserver.user.dto.UserDto;
import com.janglabs.todolistserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity singUp(UserDto.SignUp req) {
        UserEntity user = UserEntity.builder()
                .name(req.getName())
                .email(req.getEmail())
                .isDeleted("N")
                .password(passwordEncoder.encode(req.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity update(UserDto.Update req) {
        UserEntity user = userRepository.findById(req.getId()).orElseThrow();
        user.update(passwordEncoder.encode(req.getPassword()), req.getName());

        return userRepository.save(user);
    }

    public UserEntity softDelete(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.delete();

        return userRepository.save(user);
    }
}
