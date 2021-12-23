package oil.moe;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class OtherTest {
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
}
