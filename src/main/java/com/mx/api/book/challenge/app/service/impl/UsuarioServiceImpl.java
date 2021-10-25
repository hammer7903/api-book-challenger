package com.mx.api.book.challenge.app.service.impl;


import com.mx.api.book.challenge.app.model.entity.UserEntity;
import com.mx.api.book.challenge.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usuario = userRepository.findByUsername(username);
        ArrayList<UserRoles> roles = new ArrayList<>();
        if(Objects.isNull(usuario)) {
            log.error("Error en el login, no existe el usuario");
            throw new UsernameNotFoundException("Error en el login, no existe el usuario");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (usuario.getRole().equals("ROLE_USER")) {
            UserRoles role = new UserRoles();
            role.setRoleName(usuario.getRole());
            roles.add(role);

            return new User(usuario.getUsername(), usuario.getPassword(),true,true,true,true, authorities);
        }else {
            throw new UsernameNotFoundException(username);
        }
    }
}
