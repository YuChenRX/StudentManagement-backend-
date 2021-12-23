package oil.moe;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
class SpringDataJpaApplicationTests {
//
//@Autowired
//BaseLoginInfoDB db;

    @Test
    @Transactional
    @Commit
    void contextLoads() {

//        log.atLevel(new Level("t",1)).log("11");
        System.out.println("==========");
//        BaseLoginInfo user = new BaseLoginInfo(null, "11", "11", AuthorityUtils.createAuthorityList("USER","ROOT"));
//        db.save(user);
//        System.out.println(db.findAll());
        System.out.println("==========");
    }
}
