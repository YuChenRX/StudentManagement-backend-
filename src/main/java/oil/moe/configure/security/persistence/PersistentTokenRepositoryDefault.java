package oil.moe.configure.security.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configurable
@Component
public class PersistentTokenRepositoryDefault {


    @Autowired
    DataSource ds;
    @Bean
    PersistentTokenRepository getPersistentTokenRepository(){
        // 使用 JDBC 的 Token 实现
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        //此处需要数据源 （注入就好,已经有该对象了）
        jdbcTokenRepository.setDataSource(ds);
        //此处需要注意,只能执行一次(这个是创建需要的数据库表)
        jdbcTokenRepository.setCreateTableOnStartup(false);
        //返回出去,交给Spring
        return jdbcTokenRepository;
    }
}
