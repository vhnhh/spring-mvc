package ra.demo_spring_mvc.dao;

import ra.demo_spring_mvc.model.Post;

import java.util.List;

public interface IPostDao {
    List<Post> findAllPost();
    void createPost(Post post);
    void editPost(Post post);
    void deletePost(int postId);
    List<Post> findAllPostByTitleOrContent(String search);

    Post findById(int id);
}
