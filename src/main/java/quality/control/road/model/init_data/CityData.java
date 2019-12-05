package quality.control.road.model.init_data;

import java.util.Arrays;
import quality.control.road.model.City;
import quality.control.road.repository.CityRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class CityData {

    private final CityRepository cityRepository;
    public static List<City> cityList = new ArrayList();

    public CityData(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @PostConstruct
    public void createCity() {
        filledCity();
        cityRepository.saveAll(cityList);
    }

    private void filledCity() {
        cityList.addAll(
                Arrays.asList(City.builder()
                        .name("Самара")
                        .build(),
                        City.builder()
                                .name("Москва")
                                .build(),
                        City.builder()
                                .name("Тольяти")
                                .build(),
                        City.builder()
                                .name("Шентала")
                                .build())
        );
    }
}
