package by.staravoyt.app.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**", "/index.jsp",
                        "/list-coaches",
                        "/update-coach",
                        "/add-coach",
                        "/delete-coach",
                        "/update-student",
                        "/get-student",
                        "/coach/add-coach.jsp",
                        "/refresh-student",
                        "/list-students").permitAll()
//                .antMatchers("/api/coach").authenticated()
            .antMatchers("/api/coach/*").permitAll()

                .antMatchers("/info").hasAnyAuthority("ROLE_ADMIN", "READ_INFO")
//                .antMatchers("/info").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/self").hasRole("USER")
                .and().formLogin()
                .and().httpBasic()
                .and().logout().logoutSuccessUrl("/")
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(@Autowired UserDetailsService userService,
                                                               @Autowired PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

}
