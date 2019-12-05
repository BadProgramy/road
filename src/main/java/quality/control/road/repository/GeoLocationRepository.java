package quality.control.road.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import quality.control.road.model.GeoLocation;

@Repository
public interface GeoLocationRepository extends PagingAndSortingRepository<GeoLocation, Long> {
}
