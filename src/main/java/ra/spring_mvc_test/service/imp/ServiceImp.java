package ra.spring_mvc_test.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.spring_mvc_test.dao.IDao;
import ra.spring_mvc_test.modal.Song;
import ra.spring_mvc_test.service.IService;

import java.util.List;

@Service
public class ServiceImp implements IService {
    @Autowired
    private IDao songDao;
    @Override
    public List<Song> getAllSong() {
        return songDao.getAllSong();
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
