package quality.control.road.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import quality.control.road.model.User;


public interface UserRepository extends PagingAndSortingRepository<User, String> {

    @Query("select u from User u where u.username = :username")
    User findUserByName(@Param("username") String username);
}
