package it.academy.monitorSensorProject.web.security;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new it.academy.monitorSensorProject.web.security.UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                    .authorizeRequests()
                    .antMatchers("/").hasAnyAuthority("USER", "ADMIN")
                    .antMatchers("/allsensors").hasAnyAuthority("USER", "ADMIN")
                    .antMatchers("/allsensors/edit/**").hasAnyAuthority("ADMIN")
                    .antMatchers("/allsensors/delete/**").hasAuthority("ADMIN")
                    .antMatchers("/allsensors/add/**").hasAuthority("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/allsensors", true)
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login");
    }

}
