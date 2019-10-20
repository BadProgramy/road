package quality.control.road.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quality.control.road.dto.Info;

@RestController
@RequestMapping("/api/outer")
@Api(tags = "[outer api] Main", description = "Start application info without auth")
public class MainOuterController {

    @GetMapping("/main")
    @ApiOperation("Get info example out for Artem Belyaev")
    public Info main() {
        return new Info();
    }
}
