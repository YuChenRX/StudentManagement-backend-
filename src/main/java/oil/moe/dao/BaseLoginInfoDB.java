package oil.moe.dao;

import oil.moe.dto.loginInfo.BaseLoginInfo;
import org.springframework.data.repository.CrudRepository;

public interface BaseLoginInfoDB extends CrudRepository<BaseLoginInfo, Long> {
    BaseLoginInfo findByUsername(String username);
}
