package com.fila.Spring_Boo_.and_Thymeleaf.Services;

import com.fila.Spring_Boo_.and_Thymeleaf.Model.Role;
import com.fila.Spring_Boo_.and_Thymeleaf.Model.Usuarios;
import com.fila.Spring_Boo_.and_Thymeleaf.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Transient
@Service
public class SSUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository repository;

    public SSUserDetailsService(UserRepository repository){

        this.repository = repository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{

            Usuarios user = repository.findByUsername(username);

            if(user == null){

                return null;

            }

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getSenha(), getAuthorities(user));

        }catch (Exception e){

            throw new UsernameNotFoundException("User Not Found! ");

        }
    }

    private Set<GrantedAuthority> getAuthorities(Usuarios user){

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (Role role : user.getRoles()){

            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());

            authorities.add(grantedAuthority);
        }

        return authorities;

    }
}
