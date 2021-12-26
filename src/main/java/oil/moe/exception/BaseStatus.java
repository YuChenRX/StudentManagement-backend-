package oil.moe.exception;

import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
public enum BaseStatus {
    NotFindUsername("该用户不存在！", HttpServletResponse.SC_OK),
    AccessDenied("您的权限不足！请检查您的账号或者寻找管理员进行申请！", HttpServletResponse.SC_OK),
    RuntimeError("服务器产生异常！请稍后重试！", HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
    OK("OK", HttpServletResponse.SC_OK),
    DeleteSuccess("删除成功！", HttpServletResponse.SC_OK),
    SaveSuccess("添加数据成功！", HttpServletResponse.SC_OK),
    ModifySuccess("修改数据成功！", HttpServletResponse.SC_OK),
    ;
    private final int code;
    private final String message;

    private BaseStatus(String message, int code) {
        this.code = code;
        this.message = message;
    }


    private BaseStatus(BaseStatus es) {
        this.code = es.code;
        this.message = es.message;
    }
}