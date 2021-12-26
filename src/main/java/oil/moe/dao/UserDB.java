package oil.moe.dao;

import oil.moe.dto.loginInfo.User;
import org.springframework.data.repository.CrudRepository;


public interface UserDB extends CrudRepository<User,Long> {
}
