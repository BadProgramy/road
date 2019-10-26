package quality.control.road.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import quality.control.road.model.Role;
import quality.control.road.model.User;
import quality.control.road.repository.UserRepository;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userRepository.findUserByName(username);
        System.out.println("Идет создание user, пришел = " + username);
        User user = User.builder()
                .id(1L)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .firstname("Имя")
                .secondname("Фамилие")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .role(Arrays.asList(Role.ADMIN, Role.DEVELOPER))
                .username("admin")
                .build();
        if (user!=null) return user;
        else throw new UsernameNotFoundException("Пользователь " + username + " не был найден!");
    }
}
