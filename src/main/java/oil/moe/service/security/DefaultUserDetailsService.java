package oil.moe.service.security;

import lombok.extern.log4j.Log4j2;
import oil.moe.dao.BaseLoginInfoDB;
import oil.moe.dto.loginInfo.BaseLoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
@Log4j2
public class DefaultUserDetailsService implements UserDetailsService {


    @Autowired
    PasswordEncoder pe;

    @Autowired
    BaseLoginInfoDB db;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseLoginInfo user = db.findByUsername(username);
        Assert.notNull(user, () -> {
            throw new UsernameNotFoundException("user name don't exist!");
        });
        return new
                User(username, user.getPassword(), user.
                getAuthority());
    }
}

