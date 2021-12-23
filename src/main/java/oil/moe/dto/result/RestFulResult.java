package oil.moe.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RestFulResult {
    int code;
    RestfulData data;

}
