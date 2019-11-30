package quality.control.road.controller.inner;

import quality.control.road.dto.requests.RoadProblemRequest;
import quality.control.road.dto.response.RoadProblemResponse;
import quality.control.road.model.RoadProblem;
import quality.control.road.repository.RoadProblemRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@Api(tags = "[inner api] Road problem", description = "manage road problem")
@RequestMapping("/api/internal")
public class RoadProblemController {

    @Autowired
    private RoadProblemRepository roadProblemRepository;

    @GetMapping("/city/{cityName}/road-problems")
    public List<RoadProblemResponse> getRoadProblems(@PathVariable("cityName") String cityName) {
        Sort sort = Sort.by("created_at");
        return StreamSupport.stream(roadProblemRepository.findAll(sort).spliterator(), false)
                .map(roadProblem -> RoadProblemResponse.builder()
                        .id(roadProblem.getId())
                        .title(roadProblem.getTitle())
                        .description(roadProblem.getDescription())
                        .hight(roadProblem.getHeight())
                        .width(roadProblem.getWidth())
                        .createdAt(roadProblem.getCreatedAt())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createRoadProblem(RoadProblemRequest request) {
        roadProblemRepository.save(
                RoadProblem.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .height(request.getHeight())
                        .width(request.getWidth())
                        .createdAt(request.getCreatedAt())
                .build()
        );
    }
}
