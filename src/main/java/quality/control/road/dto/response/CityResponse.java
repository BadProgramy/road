package quality.control.road.dto.response;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityResponse {
    @ApiParam(value = "Идентификатор")
    private Long id;

    @ApiParam(value = "Название города")
    private String name;
}
