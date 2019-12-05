package quality.control.road.dto.requests;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentInsertRequest {

    @ApiParam(value = "Описание")
    private String description;

    @ApiParam(value = "Пользователь")
    private Long userId;

    @ApiParam(value = "Проблемная зона")
    private Long roadProblemId;
}
