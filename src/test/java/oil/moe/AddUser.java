package oil.moe;

import lombok.extern.log4j.Log4j2;
import oil.moe.dao.BaseLoginInfoDB;
import oil.moe.dao.StudentDB;
import oil.moe.dao.TeacherDB;
import oil.moe.dto.loginInfo.User;
import oil.moe.dto.student.Student;
import oil.moe.dto.teacher.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Component
@Log4j2
@Configurable
public class AddUser {
    @Autowired
    BaseLoginInfoDB loginInfoDB;

    @Autowired
    StudentDB sDB;
    @Autowired
    TeacherDB tDB;


    @Autowired
    PasswordEncoder pe;

    @Test
    @Transactional
    @Commit
    public void addUser() {
        loginInfoDB.save(
                new User(
                        "1",
                        pe.encode("1"),
                        AuthorityUtils.createAuthorityList("ROOT", "USER")));
    }

    @Test
    @Transactional
    @Commit
    public void addStudent() {
        Teacher t1 = new Teacher(null, "t1", null);
        sDB.save(new Student(null, "s1", 12, null, List.of(t1)));
    }


    @Test
    @Transactional
    @Commit
    public void modifyTeacher() {
        Teacher t1 = new Teacher(null, "t1", null);
        tDB.save(
                new Teacher(null,"t1",List.of(new Student("s1",null,null)))
        );
    }
}
