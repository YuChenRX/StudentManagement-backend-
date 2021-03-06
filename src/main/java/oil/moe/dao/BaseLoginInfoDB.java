package oil.moe.dao;

import oil.moe.dto.loginInfo.User;
import org.springframework.data.repository.CrudRepository;

public interface BaseLoginInfoDB extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
