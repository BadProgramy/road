package quality.control.road.model.init_data;

import quality.control.road.model.RoadProblem;
import quality.control.road.repository.RoadProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class RoadProblemData {

    private final RoadProblemRepository roadProblemRepository;

    @Autowired
    public RoadProblemData(RoadProblemRepository roadProblemRepository) {
        this.roadProblemRepository = roadProblemRepository;
    }

    @PostConstruct
    public void initRoadProblem() {
        List<RoadProblem> roadProblemList = Arrays.asList(
                new RoadProblem(null, "Титл 1", "Описание 1", 52, 42, "Советская", CityData.cityList.get(0), ZonedDateTime.now()),
                new RoadProblem(null, "Титл 2", "Описание 2", 53, 43, "Панова", CityData.cityList.get(0), ZonedDateTime.now()),
                new RoadProblem(null, "Титл 3", "Описание 3", 54, 44, "Революционная", CityData.cityList.get(0), ZonedDateTime.now())
        );
        roadProblemRepository.saveAll(roadProblemList);
    }
}
