package quality.control.road.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AutorisationResponse {
    private Integer status;

    public AutorisationResponse(HttpStatus status) {
        this.status = status.value();
    }
}
