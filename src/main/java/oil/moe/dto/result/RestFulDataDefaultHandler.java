package oil.moe.dto.result;

import oil.moe.exception.BaseStatus;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect//声明为Aspect对象
public class RestFulDataDefaultHandler {
    @AfterReturning(value = "execution(* oil.moe.service.controller..*.*(..))", returning = "obj")
    public Object ReturnData(JoinPoint jp, Object obj) {
        System.out.println("\n\n\n\n\n\n debug\n" + (obj instanceof RestfulData));
        if (!(obj instanceof RestfulData)) {
            System.out.println("\n\n\n" + obj + "\n\n\n");
            obj = new RestfulData(obj, BaseStatus.OK).toString();
            return obj;
        }
        System.out.println("!!");
        System.out.println("\n\n\n" + obj + "\n\n\n");
        return obj;
    }


    @AfterThrowing("execution(public * oil.moe.service.controller..*.*(..))")
    public RestfulData ServiceOccurException() {

        System.err.println("occur error!");
        return new RestfulData(BaseStatus.RuntimeError);
    }
}
