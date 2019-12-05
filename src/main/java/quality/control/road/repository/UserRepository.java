package quality.control.road.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quality.control.road.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    /*@Query(value = "select * from users u " +
            "left join road_problem rp on rp.user_id = u.id " +
            "left join comment c on c.road_problem_id = rp.id " +
            "left join geo_location gl on gl.id = rp.geo_location_id " +
            "left join city ct on ct.id = rp.city_id " +
            "where u.username = :username ", nativeQuery = true)
    User findUserByUsername(@Param("username") String username);*/
    User findByUsername(String username);
}
