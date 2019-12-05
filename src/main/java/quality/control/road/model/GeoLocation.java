package quality.control.road.model;

import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiParam(value = "Идентификатор")
    private Long id;

    @ApiParam(value = "Долгота")
    private double height;

    @ApiParam(value = "Ширина")
    private double width;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ApiParam(value = "Проблемные зоны дорог")
    private List<RoadProblem> roadProblems;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ApiParam(value = "Города")
    private List<City> cities;
}
