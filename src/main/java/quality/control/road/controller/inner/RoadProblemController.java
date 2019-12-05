package quality.control.road.controller.inner;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import quality.control.road.dto.requests.RoadProblemInsertRequest;
import quality.control.road.dto.requests.RoadProblemUpdateRequest;
import quality.control.road.dto.response.GeoLocationResponse;
import quality.control.road.dto.response.RoadProblemResponse;
import quality.control.road.model.City;
import quality.control.road.model.GeoLocation;
import quality.control.road.model.RoadProblem;
import quality.control.road.repository.CityRepository;
import quality.control.road.repository.GeoLocationRepository;
import quality.control.road.repository.RoadProblemRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import quality.control.road.repository.UserRepository;

@RestController
@Api(tags = "[inner api] Road problem", description = "manage road problem")
@RequestMapping("/api/internal")
public class RoadProblemController {

    @Autowired
    private RoadProblemRepository roadProblemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private GeoLocationRepository geoLocationRepository;

    @PostMapping("/road-problem")
    public void addRoadProblem(RoadProblemInsertRequest request) {
        City city = cityRepository.findById(request.getCityId()).get();
        GeoLocation location = geoLocationRepository.save(
                GeoLocation.builder()
                .cities(Arrays.asList(city))
                .height(request.getHeight())
                .width(request.getWidth())
                .build()
        );
        roadProblemRepository.save(
                RoadProblem.builder()
                        .city(city)
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .location(location)
                        .streetName(request.getStreetName())
                        .user(userRepository.findById(request.getUserId()).get())
                        .createdAt(ZonedDateTime.now())
                .build()
        );
    }

    @PutMapping("/road-problem")
    public void updateRoadProblem(RoadProblemUpdateRequest request) {
        City city = cityRepository.findById(request.getCityId()).get();
        GeoLocation location = geoLocationRepository.save(
                GeoLocation.builder()
                        .cities(Collections.singletonList(city))
                        .height(request.getHeight())
                        .width(request.getWidth())
                        .build()
        );
        roadProblemRepository.save(
                RoadProblem.builder()
                        .id(request.getId())
                        .city(city)
                        .description(request.getDescription())
                        .location(location)
                        .streetName(request.getStreetName())
                        .build()
        );
    }

    @GetMapping("/city/{cityName}/road-problems")
    public List<RoadProblemResponse> getRoadProblems(@PathVariable("cityName") String cityName) {
        Sort sort = Sort.by("createdAt");
        return roadProblemRepository.findAllByCity_Name(cityName, sort).stream()
                .map(roadProblem -> RoadProblemResponse.builder()
                        .id(roadProblem.getId())
                        .title(roadProblem.getTitle())
                        .description(roadProblem.getDescription())
                        .locationResponse(
                                GeoLocationResponse.builder()
                                        .height(roadProblem.getLocation().getHeight())
                                        .width(roadProblem.getLocation().getWidth())
                                        .build()
                        )
                        .createdAt(roadProblem.getCreatedAt())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
