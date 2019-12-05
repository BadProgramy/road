package quality.control.road.dto.requests;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoadProblemUpdateRequest {
    @ApiParam(value = "Идентификатор проблемной зоны")
    private Long id;

    @ApiParam(value = "Заглавие")
    private String title;

    @ApiParam(value = "Описание")
    private String description;

    @ApiParam(value = "Долгота")
    private Double height;

    @ApiParam(value = "Ширина")
    private Double width;

    @ApiParam(value = "Город")
    private Long cityId;

    @ApiParam(value = "Улица")
    private String streetName;
}
