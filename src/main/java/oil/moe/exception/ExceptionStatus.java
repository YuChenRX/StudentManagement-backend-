package oil.moe.exception;

import javax.servlet.http.HttpServletResponse;

public enum ExceptionStatus {
    NotFindUsername("该用户不存在！", HttpServletResponse.SC_OK),
    AccessDenied("您的权限不足！请检查您的账号或者寻找管理员进行申请！", HttpServletResponse.SC_OK),
    RuntimeError("服务器产生异常！请稍后重试！", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    ;
    private int code;
    private String message;

    private ExceptionStatus(String message, int code) {
        this.code = code;
        this.message = message;
    }
}