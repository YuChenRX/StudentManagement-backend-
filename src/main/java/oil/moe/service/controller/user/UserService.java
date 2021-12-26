package oil.moe.service.controller.user;


import oil.moe.dao.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
    @Autowired
    UserDB udb;
}
