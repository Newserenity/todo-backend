package com.janglabs.todolistserver.user.service;

import com.janglabs.todolistserver.security.JwtDto;
import com.janglabs.todolistserver.security.JwtProvider;
import com.janglabs.todolistserver.user.dto.UserDto;
import com.janglabs.todolistserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDetailsService jwtUserDetailsService;
    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public JwtDto signIn(UserDto.SignIn req) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                req.getEmail(),
                req.getPassword()
        );

        Authentication auth = authenticationManager.authenticate(
                authToken
        );

        if(auth.isAuthenticated()) {
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(req.getEmail());

            return JwtDto.builder()
                    .accessJwt(jwtProvider.create(userDetails))
                    .build();
        }

        return JwtDto.builder()
                .accessJwt("")
                .build();
    }
}
