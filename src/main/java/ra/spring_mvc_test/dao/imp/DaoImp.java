package ra.spring_mvc_test.dao.imp;

import com.mysql.cj.jdbc.CallableStatement;
import org.springframework.stereotype.Repository;
import ra.spring_mvc_test.dao.IDao;
import ra.spring_mvc_test.modal.Song;
import ra.spring_mvc_test.util.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImp implements IDao {

    @Override
    public List<Song> getAllSong() {
        List<Song> songList = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectDB.openConnection();
            callSt = (CallableStatement) conn.prepareCall("select * from song");
            ResultSet rs = callSt.executeQuery();
            songList = new ArrayList<>();
            while (rs.next()){
                Song song = new Song();
                song.setId(rs.getString("id"));
                song.setName(rs.getString("name"));
                song.setAuthor(rs.getString("author"));
                song.setDescription(rs.getString("description"));
                song.setImgUrl(rs.getString("imgUrl"));
                song.setVidUrl(rs.getString("vidUrl"));
                song.setDuration(rs.getInt("duration"));
                song.setStatus(rs.getBoolean("status"));
                songList.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectDB.closeConnection(conn, callSt);
        }
        return songList;
    }

    @Override
    public void create(Song song) {

    }

    @Override
    public void editSong(Song song) {

    }

    @Override
    public void deleteSong(String songId) {

    }

    @Override
    public List<Song> findAllSongByNameOrDescription(String search) {
        return null;
    }
}
