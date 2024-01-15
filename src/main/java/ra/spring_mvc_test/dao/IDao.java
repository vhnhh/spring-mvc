package ra.spring_mvc_test.dao;

import ra.spring_mvc_test.modal.Song;

import java.util.List;

public interface IDao {
    List<Song> getAllSong();
    void create(Song song);
    void editSong(Song song);
    void deleteSong(String songId);
    List<Song> findAllSongByNameOrDescription(String search);
}
