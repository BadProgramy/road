package quality.control.road.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadProblemRequest {
    private String title;
    private String description;
    private Double height;
    private Double width;
    private ZonedDateTime createdAt;
}
