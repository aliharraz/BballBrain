package com.Feed.BBallBrainFeed.Services;



import com.Feed.BBallBrainFeed.Entities.Post;
import com.Feed.BBallBrainFeed.Feign.PostInterface;
import com.Feed.BBallBrainFeed.Repositories.PostRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    PostInterface postInterface;

    public List<Post> getPostsForUser() {
        String userID = "UserIDfromuserservice";
        String role = "Rolefromuserservice";

//        if ("ROLE_COACH".equals(role)) {
//            return getPostsForCoach(userID);
//        } else if ("ROLE_PLAYER".equals(role)) {
//            coachId = postInterface.getCoachId(userID);
//            return getPostsForCoach(coachId);
//        } else {
//            return postRepository.findByIsPublicTrue();  // Default to public posts for other roles or unauthenticated users
//        }
        return postRepository.findByIsPublicTrue();
    }

    private List<Post> getPostsForCoach(Long  coachId) {
        return postRepository.findByIsPublicTrueAndCoachId(coachId);
    }


    public Post createPost(Post post) {
        post.setCoachId(123L);
        post.setCreatedAt(LocalDateTime.now());
        post.setPublic(true);
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
