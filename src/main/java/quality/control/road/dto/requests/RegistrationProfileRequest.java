package quality.control.road.dto.requests;

import lombok.Data;

@Data
public class RegistrationProfileRequest {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}
