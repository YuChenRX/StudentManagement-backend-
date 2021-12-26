package oil.moe.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oil.moe.exception.BaseStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestfulData {
    int code;
    Object data;
    String message;

    public RestfulData(Object data) {
        this(BaseStatus.OK, data, null);
    }

    public RestfulData(BaseStatus es, Object data, String message) {
        this.code = es.getCode();
        this.data = data;
        this.message = message;
    }

    public RestfulData(BaseStatus es) {
        this(null, es);
    }

    public RestfulData(Object data, BaseStatus es) {
        this.data = data;
        this.code = es.getCode();
        this.message = es.getMessage();
    }
}
