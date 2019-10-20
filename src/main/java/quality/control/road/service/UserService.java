package quality.control.road.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import quality.control.road.model.User;
import quality.control.road.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username);
        if (user!=null) return user;
        else throw new UsernameNotFoundException("Пользователь " + username + " не был найден!");
    }
}
