package quality.control.road.dto.requests;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentUpdateRequest {

    @ApiParam(value = "Идентификатор")
    private Long id;

    @ApiParam(value = "Описание")
    private String description;
}
