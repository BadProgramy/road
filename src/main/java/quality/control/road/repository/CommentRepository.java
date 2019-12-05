package quality.control.road.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import quality.control.road.model.Comment;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> getByRoadProblemIdOrderByCreatedAt(String roadProblemId);
}
