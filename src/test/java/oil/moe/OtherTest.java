package oil.moe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;

@SpringBootTest
public class OtherTest {

    @Autowired
    PasswordEncoder pe;

    @Test
    public int t(byte[] value) {
        int h = 0;
        for (byte v : value) {
            h = 31 * h + (v & 0xff);
        }
        return h;
    }

    @Test
    public void doe(){
        System.out.println(t("Taramasalata".getBytes(StandardCharsets.UTF_8)));
    }

    @Test
    public void encode(){
        System.out.println(pe.encode("123456"));
    }
    @Test
    public void num(){
        System.out.println(2<<1);
    }
}
