package quality.control.road.model.init_data;

import quality.control.road.model.Role;
import quality.control.road.model.User;
import quality.control.road.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class UserData {

    private final UserRepository userRepository;

    public UserData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void createTestUser() {
        User user = User.builder()
                .firstname("Тест")
                .secondname("Тестов")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .role(Arrays.asList(Role.values()))
                .username("admin")
                .build();
        user.unBlockAccount();
        userRepository.save(user);
    }
}
