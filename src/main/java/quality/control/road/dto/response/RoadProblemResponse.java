package quality.control.road.dto.response;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoadProblemResponse {
    @ApiParam(value = "Идентификатор")
    private Long id;
    @ApiParam(value = "Заглавие")
    private String title;
    @ApiParam(value = "Описание")
    private String description;
    @ApiParam(value = "Геолокация")
    private GeoLocationResponse locationResponse;
    @ApiParam(value = "Дата создания")
    private ZonedDateTime createdAt;
}