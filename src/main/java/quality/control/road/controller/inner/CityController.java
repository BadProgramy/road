package quality.control.road.controller.inner;

import quality.control.road.dto.response.CityResponse;
import quality.control.road.repository.CityRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Api(tags = "[inner api] City", description = "manage city")
@RequestMapping("/api/internal")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/city")
    @ApiOperation("get all city")
    private List<CityResponse> getAll() {
        return StreamSupport.stream(cityRepository.findAll().spliterator(), false)
                .map(it -> new CityResponse(it.getName()))
                .collect(Collectors.toList());
    }
}
