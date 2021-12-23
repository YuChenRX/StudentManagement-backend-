package oil.moe.exception;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlerDefault {
    @ExceptionHandler(value
            = {UsernameNotFoundException.class})
    public String notFindUser(Exception e) {

        return "";
    }
}

