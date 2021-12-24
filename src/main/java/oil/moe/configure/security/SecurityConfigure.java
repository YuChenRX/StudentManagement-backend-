package oil.moe.configure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

@Configurable
@Component
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PersistentTokenRepository persistentTokenRepository;

    @Override
//    Can't configure antMatchers after anyRequest
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/**")
                .permitAll()

                .and()
                .formLogin()
                .successHandler(new LoginSuccessHandle())
//                .failureHandler(new SecurityExceptionDefault())
                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
                .csrf().disable()
                .rememberMe().
                //user 的服务 源(该对象spring中存在了,注入即可)-
                        userDetailsService(userDetailsService).
                //这是上面创建的对象
                        tokenRepository(persistentTokenRepository);
    }


    @Override
    public void configure(WebSecurity web) {
        // 可以直接访问的静态数据
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/404.html")
                .antMatchers("/500.html")
                .antMatchers("/html/**")
                .antMatchers("/js/**");
    }


}
