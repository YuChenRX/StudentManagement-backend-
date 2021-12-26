package oil.moe.configure.config;

import oil.moe.configure.authority.DefaultUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DefaultUserDetailsService userDetailsService;

    @Autowired
    PersistentTokenRepository js;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .rememberMe()
                .userDetailsService(userDetailsService)
                .tokenValiditySeconds(60 * 60 * 24 * 2)
                .tokenRepository(js)
                .and()
                .csrf()
                .disable();
    }
}
