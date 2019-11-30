package quality.control.road.controller;

import quality.control.road.dto.requests.RegistrationProfileRequest;
import quality.control.road.model.User;
import quality.control.road.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/outer")
@Api(tags = "[outer api] Main", description = "Start application info without auth")
public class MainOuterController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @ApiOperation("Registration user")
    public void registrate(RegistrationProfileRequest profile) {
        User user = User.builder()
                .username(profile.getUsername())
                .password(new BCryptPasswordEncoder().encode(profile.getPassword()))
                .firstname(profile.getFirstname())
                .secondname(profile.getLastname())
                .build();
        user.unBlockAccount();
        userService.save(user);
    }
}
