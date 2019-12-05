package quality.control.road.dto.response;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {
    @ApiParam(value = "Имя")
    private String firstname;
    @ApiParam(value = "Фамилие")
    private String secondname;
}
