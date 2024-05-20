package Controllers;



import Entities.Post;
import Services.PostService;
//import Security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

//    @Autowired
//    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/coach/{coachId}")
    public List<Post> getPostsByCoachId(@PathVariable Long coachId) {
        return postService.getPostsByCoachId(coachId);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
//        String coachId = jwtAuthenticationFilter.extractUserIdFromToken(token);
        String coachId = "20";
        return postService.createPost(post, Long.valueOf(coachId));
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
