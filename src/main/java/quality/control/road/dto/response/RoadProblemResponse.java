package quality.control.road.dto.response;

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
    private Long id;
    private String title;
    private String description;
    private Double hight;
    private Double width;
    private ZonedDateTime createdAt;
}
