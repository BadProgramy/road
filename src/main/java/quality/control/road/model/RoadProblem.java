package quality.control.road.model;

import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoadProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiParam(value = "Идентификатор проблемной зоны")
    private Long id;

    @ApiParam(value = "Заглавие проблемной зоны")
    private String title;

    @ApiParam(value = "Описание проблемной зоны")
    private String description;

    @ApiParam(value = "Улица")
    private String streetName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_id")
    @ApiParam(value = "Город")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @ApiParam(value = "Пользователь, кто создал проблему")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="geo_location_id")
    @ApiParam(value = "Геолокация проблемы")
    private GeoLocation location;

    @OneToMany(mappedBy = "roadProblem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ApiParam(value = "Комментарии пользователей")
    private List<Comment> comments;

    @ApiParam(value = "Дата создания")
    private ZonedDateTime createdAt = ZonedDateTime.now();
}
