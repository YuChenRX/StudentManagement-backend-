package oil.moe.configure.authority;

import oil.moe.dao.BaseLoginInfoDB;
import oil.moe.dto.loginInfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
public class DefaultUserDetailsService implements UserDetailsService {


    @Autowired
    PasswordEncoder pe;

    @Autowired
    BaseLoginInfoDB db;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = db.findByUsername(username);
        System.out.println(user);

        Assert.notNull(user, () -> {
            throw new UsernameNotFoundException("user name don't exist!");
        });
        return new
                org.springframework.security.core.userdetails.User(username, user.getPassword(), user.
                getAuthority());
    }
}

