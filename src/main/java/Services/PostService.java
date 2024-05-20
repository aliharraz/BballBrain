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

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByCoachId(Long coachId) {
        return postRepository.findByCoachId(coachId);
    }

    public Post createPost(Post post, Long coachId) {
        post.setCoachId(coachId);
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
