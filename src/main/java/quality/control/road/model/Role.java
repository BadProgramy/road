package quality.control.road.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ADMIN("Администратор"),
    DEVELOPER("Разработчик");

    private String name;

    @Override
    public String getAuthority() {
        return name();
    }
}
