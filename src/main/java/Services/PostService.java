package Services;



import Entities.Post;
import Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    public List<Post> getPostsForUser() {
        String username = "Usernamefromuserservice";
        String role = "Rolefromuserservice";

        if ("ROLE_COACH".equals(role)) {
            return getPostsForCoach(username);
        } else if ("ROLE_PLAYER".equals(role)) {
            String coachUsername = "coachusernamefromservice";
            return getPostsForPlayer(coachUsername);
        } else {
            return postRepository.findByIsPublicTrue();  // Default to public posts for other roles or unauthenticated users
        }
    }

    private List<Post> getPostsForCoach(String coachUsername) {
        return postRepository.findByIsPublicTrueOrOwnerUsername(coachUsername);
    }

    private List<Post> getPostsForPlayer(String coachUsername) {
        return postRepository.findByIsPublicTrueOrOwnerUsername(coachUsername);
    }


    public Post createPost(Post post, Long coachId) {
        post.setCoachId(coachId);
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
