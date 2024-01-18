package ra.demo_spring_mvc.dao.imp;

import com.mysql.cj.jdbc.CallableStatement;
import org.springframework.stereotype.Repository;
import ra.demo_spring_mvc.dao.IPostDao;
import ra.demo_spring_mvc.model.Post;
import ra.demo_spring_mvc.util.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDaoImp implements IPostDao {
    @Override
    public List<Post> findAllPost() {
        List<Post> postList = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectDB.openConnection();
            callSt = (CallableStatement) conn.prepareCall("select * from post");
            ResultSet rs = callSt.executeQuery();
            postList = new ArrayList<>();
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setAuthor(rs.getString("author"));
                p.setContent(rs.getString("content"));
                p.setImgUrl(rs.getString("imgUrl"));
                p.setTime(rs.getTimestamp("time"));
                postList.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
        return postList;
    }

    @Override
    public void createPost(Post post) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectDB.openConnection();
            callSt = (CallableStatement) conn.prepareCall("insert into post (title, author, content, imgUrl) values (?, ?, ?, ?)");
            callSt.setString(1, post.getTitle());
            callSt.setString(2, post.getAuthor());
            callSt.setString(3, post.getContent());
            callSt.setString(4, post.getImgUrl());
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void editPost(Post post) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectDB.openConnection();
            callSt = (CallableStatement) conn.prepareCall("update post set title=?, content=?, author=?, imgUrl=? where id=?");
            callSt.setString(1, post.getTitle());
            callSt.setString(2, post.getContent());
            callSt.setString(3, post.getAuthor());
            callSt.setString(4, post.getImgUrl());
            callSt.setInt(5, post.getId());
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void deletePost(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectDB.openConnection();
            callSt = (CallableStatement) conn.prepareCall("delete from post where id = ?");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public List<Post> findAllPostByTitleOrContent(String search) {
        List<Post> searchList = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            searchList = new ArrayList<>();
            conn = ConnectDB.openConnection();
            callSt = (CallableStatement) conn.prepareCall("select * from post where title like ? or content like ?");
            callSt.setString(1, "%" + search + "%");
            callSt.setString(2, "%" + search + "%");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setAuthor(rs.getString("author"));
                p.setContent(rs.getString("content"));
                p.setImgUrl(rs.getString("imgUrl"));
                p.setTime(rs.getTimestamp("time"));
                searchList.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
        return searchList;
    }

    @Override
    public Post findById(int id) {
        Post p = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            p = new Post();
            conn = ConnectDB.openConnection();
            callSt = (CallableStatement) conn.prepareCall("select * from post where id = ?");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setAuthor(rs.getString("author"));
                p.setContent(rs.getString("content"));
                p.setImgUrl(rs.getString("imgUrl"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
        return p;
    }
}
