package oil.moe;

import lombok.extern.log4j.Log4j2;
import oil.moe.dao.BaseLoginInfoDB;
import oil.moe.dto.loginInfo.BaseLoginInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Component
@Log4j2
@Configurable
public class AddUser {
    @Autowired
    BaseLoginInfoDB db;

    @Autowired
    PasswordEncoder pe;

    @Transactional
    @Commit
    public void addUser(String username, String password, String... authority) {
        log.atTrace().log(db);
        db.save(
                new BaseLoginInfo(
                        null,
                        username,
                        pe.encode(password),
                        AuthorityUtils.createAuthorityList(authority)));
    }

    @Test
    public void addUser(String username, String password) {
        addUser(username, password, "USER");
    }

    @Test
    @Transactional
    @Commit
    public void run() {
        db.save(
                new BaseLoginInfo(
                        null,
                        "root",
                        pe.encode("root"),
                        AuthorityUtils.createAuthorityList("ROOT","USER")));
    }
}
