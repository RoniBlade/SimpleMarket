package org.larbcorp.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, PersistentTokenRepository tokenRepository) throws Exception {
        httpSecurity.csrf().disable();

        httpSecurity.formLogin()
                        .loginPage("/signIn")
                        .defaultSuccessUrl("/profile")
                        .failureUrl("/signIn?error")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .permitAll()
                        .and()
                        .logout()
                        .permitAll();

//        httpSecurity.authorizeHttpRequests().antMatchers("/css/**").permitAll();
//        httpSecurity.authorizeHttpRequests().antMatchers("/**").authenticated();
        httpSecurity.authorizeHttpRequests().antMatchers("/users/**").hasAuthority("ADMIN");

        return httpSecurity.build();
    }

    @Autowired
    public void bindUserDetailsService(AuthenticationManagerBuilder builder) throws Exception {

        builder.userDetailsService(customUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public PersistentTokenRepository tokenRepository(DataSource dataSource){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

}
