package quality.control.road.dto.response;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommentResponse {
    @ApiParam(value = "Идентификатор")
    private Long id;

    @ApiParam(value = "Описание")
    private String description;

    @ApiParam(value = "Пользователь")
    private UserResponse user;

    @ApiParam(value = "Проблемная зона")
    private RoadProblemResponse roadProblem;
}
