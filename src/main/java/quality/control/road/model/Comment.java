package quality.control.road.model;

import io.swagger.annotations.ApiParam;
import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiParam(value = "Идентификатор")
    private Long id;

    @ApiParam(value = "Описание")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @ApiParam(value = "Пользователь")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="road_problem_id")
    @ApiParam(value = "Проблемные зоны дорог")
    private RoadProblem roadProblem;

    private ZonedDateTime createdAt = ZonedDateTime.now();
}
