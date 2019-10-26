package quality.control.road.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quality.control.road.dto.AutorisationResponse;
import quality.control.road.dto.Info;

@RestController
@RequestMapping("/api/internal")
@Api(tags = "[inner api] Main", description = "Start application info in internal service by auth")
public class MainInnerController {

    @GetMapping("/main")
    @ApiOperation("Get info example out for Artem Belyaev")
    public Info main() {
        return new Info();
    }

    @GetMapping("/login/result")
    public AutorisationResponse loginResult() {
        System.out.println("Возвращаю Login result");
        return new AutorisationResponse(HttpStatus.OK);
    }
}
