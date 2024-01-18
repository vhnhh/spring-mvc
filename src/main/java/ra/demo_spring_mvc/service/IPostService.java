package ra.demo_spring_mvc.service;

import ra.demo_spring_mvc.model.Post;

import java.util.List;

public interface IPostService {
    List<Post>findAllPosts();
    void createPost(Post post);
    void editPost(Post post);
    void deletePost(int postId);
    List<Post> findAllPostByTitleOrContent(String search);
    Post findById(int id);

}
