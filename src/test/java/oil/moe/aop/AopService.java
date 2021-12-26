package oil.moe.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootTest
@Aspect
public class AopService {
    @Test
    @After(value = "execution(* oil.moe.aop..*.*(..))")
    public void test(){
        System.out.println("add");
        System.out.println("obj");
    }
}
