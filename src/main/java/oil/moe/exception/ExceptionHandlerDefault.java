package oil.moe.exception;


import lombok.extern.log4j.Log4j2;
import oil.moe.dto.result.RestfulData;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@Log4j2
public class ExceptionHandlerDefault {
    // not found
    @ExceptionHandler(value
            = {UsernameNotFoundException.class})
    public Object notFindUserInLogin(Exception e) {
        return new RestfulData(BaseStatus.NotFindUsername);
    }


    // occur error
    @ExceptionHandler(value
            = {Exception.class})
    public Object Error(Exception e) {
        log.info("!!!!!");
        return new RestfulData(BaseStatus.RuntimeError);
//        System.exit(-1230);
    }


}

