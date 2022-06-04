package company.securingweb;

import company.entity.User.Role;
import company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration", "/menu").permitAll()
                    .antMatchers("/homepage").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                    .antMatchers("/userlist/**").hasRole( Role.ADMIN.name())
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/perform-login")
//                .usernameParameter("username")
//                .passwordParameter("password")
                .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                .logoutSuccessUrl("/login")
                .logoutUrl("/perform_logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
//                .passwordEncoder(bCryptPasswordEncoder());
    }
}