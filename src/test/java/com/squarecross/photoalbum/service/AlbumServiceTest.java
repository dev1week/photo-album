package com.squarecross.photoalbum.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.squarecross.photoalbum.domain.Album;
import com.squarecross.photoalbum.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AlbumServiceTest {
  
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Test
    void getAlbum() {
        Album album = new Album();
        album.setAlbumName("테스트 앨범입니다.");
        Album saveAlbum = albumRepository.save(album);

        Album searchedAlbum = albumService.getAlbum(saveAlbum.getAlbumId());

        assertEquals(album.getAlbumName(), searchedAlbum.getAlbumName());
    }


    @Test
    void getAlbumByName() {

        Album album2 = new Album();
        Album album1 = new Album();
        Album album3 = new Album();

        album1.setAlbumName("test");
        album2.setAlbumName("test2");
        album3.setAlbumName("test3");

        Album saveAlbum1 = albumRepository.save(album1);
        Album saveAlbum2 = albumRepository.save(album2);
        Album saveAlbum3 = albumRepository.save(album3);




        List<Album> searchedAlbum = albumService.getAlbumByName("test");

    }
}