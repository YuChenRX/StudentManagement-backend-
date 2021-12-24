package oil.moe.exception;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerDefault {
    @ExceptionHandler(value
            = {UsernameNotFoundException.class})
    public String notFindUser(Exception e) {
        System.out.println("------------\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------\n\n\n\n\n\n\n\n\n\n");
        return "";
    }
}

