// package th.mfu;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/admin/**").hasRole("ADMIN") // Requires "ADMIN" role for /admin and its sub-paths
//                 .anyRequest().authenticated()
//                 .and()
//             .formLogin()
//                 .loginPage("/login") // Set your custom login page
//                 .successHandler(authenticationSuccessHandler) // Use the custom success handler
//                 .permitAll()
//                 .and()
//             .httpBasic()
//                 .and()
//             .logout()
//                 .logoutSuccessUrl("/login?logout")
//                 .permitAll();
//     }
// }


