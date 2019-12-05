package quality.control.road.controller.inner;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quality.control.road.dto.requests.CommentInsertRequest;
import quality.control.road.dto.requests.CommentUpdateRequest;
import quality.control.road.dto.response.CommentResponse;
import quality.control.road.dto.response.GeoLocationResponse;
import quality.control.road.dto.response.RoadProblemResponse;
import quality.control.road.dto.response.UserResponse;
import quality.control.road.model.Comment;
import quality.control.road.repository.CommentRepository;
import quality.control.road.repository.RoadProblemRepository;
import quality.control.road.repository.UserRepository;

@RestController
@Api(tags = "[inner api] Comments", description = "manage comments")
@RequestMapping("/api/internal")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RoadProblemRepository roadProblemRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/comments")
    @ApiOperation("add comment to user")
    public void addComment(CommentInsertRequest request) {
        commentRepository.save(
                Comment.builder()
                        .description(request.getDescription())
                        .roadProblem(roadProblemRepository.findById(request.getRoadProblemId()).get())
                        .user(userRepository.findById(request.getUserId()).get())
                .build()
        );
    }

    @PutMapping("/comments")
    public void updateComment(CommentUpdateRequest request) {
        commentRepository.save(
                Comment.builder()
                        .id(request.getId())
                        .description(request.getDescription())
                        .build()
        );
    }

    @GetMapping("/comments")
    @ApiOperation("get all comments")
    public List<CommentResponse> getAll() {
        return StreamSupport.stream(commentRepository.findAll().spliterator(), false)
                .map(
                        it -> CommentResponse.builder()
                                .id(it.getId())
                                .description(it.getDescription())
                                .roadProblem(
                                        RoadProblemResponse.builder()
                                                .id(it.getRoadProblem().getId())
                                                .locationResponse(
                                                        GeoLocationResponse.builder()
                                                                .width(it.getRoadProblem().getLocation().getWidth())
                                                                .height(it.getRoadProblem().getLocation().getHeight())
                                                                .build()
                                                )
                                                .createdAt(it.getRoadProblem().getCreatedAt())
                                                .description(it.getRoadProblem().getDescription())
                                                .title(it.getRoadProblem().getTitle())
                                                .build()
                                )
                                .user(
                                        UserResponse.builder()
                                                .firstname(it.getUser().getFirstname())
                                                .secondname(it.getUser().getSecondname())
                                                .build()
                                )
                                .build()
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/comments/road-problem/{roadProblemId}")
    @ApiOperation("get all comments by roadProblemId")
    public List<CommentResponse> getCommentsByRoadProblemId(@PathVariable("roadProblemId") String roadProblemId) {
        return commentRepository.getByRoadProblemIdOrderByCreatedAt(roadProblemId).stream()
                .map(
                        comment -> CommentResponse.builder()
                                .id(comment.getId())
                                .description(comment.getDescription())
                                .user(
                                        UserResponse.builder()
                                                .firstname(comment.getUser().getFirstname())
                                                .secondname(comment.getUser().getSecondname())
                                                .build()
                                )
                                .roadProblem(
                                        RoadProblemResponse.builder()
                                                .id(comment.getRoadProblem().getId())
                                                .locationResponse(
                                                        GeoLocationResponse.builder()
                                                                .width(comment.getRoadProblem().getLocation().getWidth())
                                                                .height(comment.getRoadProblem().getLocation().getHeight())
                                                                .build()
                                                )
                                                .createdAt(comment.getRoadProblem().getCreatedAt())
                                                .description(comment.getRoadProblem().getDescription())
                                                .title(comment.getRoadProblem().getTitle())
                                                .build()
                                )
                        .build()
                )
                .collect(Collectors.toList());
    }
}
