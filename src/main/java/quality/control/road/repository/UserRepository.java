package quality.control.road.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quality.control.road.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("select u from User u where u.username = :username")
    User findUserByName(@Param("username") String username);
}
