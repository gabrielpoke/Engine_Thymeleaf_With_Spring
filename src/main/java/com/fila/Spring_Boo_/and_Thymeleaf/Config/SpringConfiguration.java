package com.fila.Spring_Boo_.and_Thymeleaf.Config;

import com.fila.Spring_Boo_.and_Thymeleaf.Repository.UserRepository;
import com.fila.Spring_Boo_.and_Thymeleaf.Services.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private SSUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(userRepository);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/").access("hasAnyAuthority('ADM')").
                antMatchers("/admin").access("hasAnyAuthority('ADM')").anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll().permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll().and().httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//       auth.inMemoryAuthentication()
//               .withUser("user").password(passwordEncoder().encode("password")).authorities("USER")
//               .and()
//               .withUser("ADM").password(passwordEncoder().encode("123")).authorities("ADM");

        auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());

    }

}
