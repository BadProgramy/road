package quality.control.road.dto.response;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GeoLocationResponse {
    @ApiParam(value = "Долгота")
    private Double height;
    @ApiParam(value = "Ширина")
    private Double width;
}
