package com.fila.Spring_Boo_.and_Thymeleaf.Config;

import com.fila.Spring_Boo_.and_Thymeleaf.Model.Role;
import com.fila.Spring_Boo_.and_Thymeleaf.Model.Usuarios;
import com.fila.Spring_Boo_.and_Thymeleaf.Repository.RoleRepository;
import com.fila.Spring_Boo_.and_Thymeleaf.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

//        roleRepository.save(new Role("USER"));
//
//        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");

        Role userRole = roleRepository.findByRole("USER");

        Usuarios usuario = new Usuarios("administrador@gmail.com", passwordEncoder.encode("123"), "administrador", "Teste", true, "admin");

        usuario.setRoles(Arrays.asList(adminRole));
        userRepository.save(usuario);

        usuario = new Usuarios("user@gmail.com", passwordEncoder.encode("456"), "usuario", "Teste", true, "user");

        usuario.setRoles(Arrays.asList(userRole));
        userRepository.save(usuario);

    }
}
