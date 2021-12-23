package oil.moe.dto.result;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestFulBuilder implements HandlerInterceptor {
    public static RestfulData builder(int code, Object object, String message) {
        restfulData.data = object;
        restfulData.code = code;
        restfulData.message = message;
        return new RestfulData(code,object,message);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {

        }
    }

    static RestfulData restfulData;


}
