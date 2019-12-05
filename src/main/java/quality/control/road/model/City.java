package quality.control.road.model;

import io.swagger.annotations.ApiParam;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiParam(value = "Идентификатор")
    private Long id;
    @ApiParam(value = "Флаг учетные данные не истекли")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ApiParam(value = "Проблемные зоны дорог")
    private List<RoadProblem> roadProblems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="geo_location_id")
    @ApiParam(value = "Геолокация")
    private GeoLocation location;
}
