package oil.moe.configure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorityServiceConfigure extends AuthorizationServerConfigurerAdapter {

    @Autowired
    DataSource ds;
//
//    @Bean
//    public TokenStore tokenStore() {
//        // 基于 JDBC 实现，令牌保存到数据
//        return new JdbcTokenStore(ds);
//    }
//
//    @Bean
//    public ClientDetailsService jdbcClientDetails() {
//        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
//        return new JdbcClientDetailsService(ds);
//    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        // 设置令牌
//        endpoints.tokenStore(tokenStore());
//    }
@Autowired
    PasswordEncoder pe;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 读取客户端配置
//        clients.withClientDetails(jdbcClientDetails());
        // 配置客户端
        clients
                // 使用内存设置
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret(pe.encode("secret"))
                // 授权类型
                .authorizedGrantTypes("authorization_code")
                // 授权范围
                .scopes("all")
                // 注册回调地址
                .redirectUris("http://www.funtl.com");
    }
}
