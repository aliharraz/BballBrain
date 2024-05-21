package Repositories;




import Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCoachId(Long coachId);
    List<Post> findByIsPublicTrue();
    List<Post> findByOwnerUsername(String username);
    List<Post> findByIsPublicTrueOrOwnerUsername(String username);
}
