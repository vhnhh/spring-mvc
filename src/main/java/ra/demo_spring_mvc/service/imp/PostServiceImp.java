package ra.demo_spring_mvc.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo_spring_mvc.dao.IPostDao;
import ra.demo_spring_mvc.model.Post;
import ra.demo_spring_mvc.service.IPostService;

import java.util.List;

@Service
public class PostServiceImp implements IPostService {
    @Autowired
    private IPostDao postDao;

    @Override
    public List<Post> findAllPosts() {
        return postDao.findAllPost();
    }

    @Override
    public void createPost(Post post) {
        postDao.createPost(post);
    }

    @Override
    public void editPost(Post post) {
        postDao.editPost(post);
    }

    @Override
    public void deletePost(int postId) {
        postDao.deletePost(postId);
    }

    @Override
    public List<Post> findAllPostByTitleOrContent(String search) {
        return postDao.findAllPostByTitleOrContent(search);
    }

    @Override
    public Post findById(int id) {
        return postDao.findById(id);
    }
}
