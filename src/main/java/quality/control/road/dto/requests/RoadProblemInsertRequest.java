package quality.control.road.dto.requests;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadProblemInsertRequest {
    @ApiParam(value = "Заглавие")
    private String title;

    @ApiParam(value = "Описание")
    private String description;

    @ApiParam(value = "Долгота")
    private Double height;

    @ApiParam(value = "Ширина")
    private Double width;

    @ApiParam(value = "Пользователь")
    private Long userId;

    @ApiParam(value = "Город")
    private Long cityId;

    @ApiParam(value = "Улица")
    private String streetName;
}
