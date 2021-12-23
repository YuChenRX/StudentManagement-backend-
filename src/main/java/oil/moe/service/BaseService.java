package oil.moe.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "base service")
public class BaseService {
    @ApiOperation("test")
    @RequestMapping("/test")
    public String test() {
        return "1";
    }

    @GetMapping("")
    public String success() {
        return "success!";
    }
}
