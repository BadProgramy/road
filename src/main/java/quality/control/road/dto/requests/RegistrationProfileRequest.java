package quality.control.road.dto.requests;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class RegistrationProfileRequest {
    @ApiParam(value = "Логин")
    private String username;
    @ApiParam(value = "Пароль")
    private String password;
    @ApiParam(value = "Имя")
    private String firstname;
    @ApiParam(value = "Фамилие")
    private String lastname;
}
