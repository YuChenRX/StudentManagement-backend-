package oil.moe.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oil.moe.dto.result.RestfulData;
import oil.moe.exception.BaseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "base service")
public class TestSome1 {
    @ApiOperation("test")
    @RequestMapping("/test")
    public String test() {
        System.out.println(1/0);
        return "1";
    }

    @ApiOperation("will return a string success")
    @GetMapping("/")
    public String success() {
        return "success!";
    }


    @ApiOperation("will return no restFulData")
    @GetMapping("/no")
    public String noHasData() {
        return "success!";
    }


    @ApiOperation("return has RestFulData Obj")
    @GetMapping("/testData")
    public RestfulData t(){
        return new RestfulData(BaseStatus.SaveSuccess,"bababa","msg");
    }
}
