package com.squarecross.photoalbum.service;
import com.squarecross.photoalbum.domain.Photo;
import com.squarecross.photoalbum.dto.AlbumDto;
import com.squarecross.photoalbum.repository.PhotoRepository;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@SpringBootTest
@Transactional
class AlbumServiceTest {
  
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;


    @Autowired
    PhotoRepository photoRepository;

    @Test
    void getAlbum() {
        Album album = new Album();
        album.setAlbumName("테스트 앨범입니다.");
        Album saveAlbum = albumRepository.save(album);

        AlbumDto searchedAlbum = albumService.getAlbum(saveAlbum.getAlbumId());

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

        List<Album> searchedAlbums = albumService.getAlbumByName("test");


        assertEquals(album1.getAlbumName(),searchedAlbums.get(0).getAlbumName());

    }

//    @Test
//    void testPhotoCount(){
//
//        //given
//        Album album = new Album();
//
//        album.setAlbumName("테스트");
//        Album savedAlbum = albumRepository.save(album);
//        log.info(album.toString());
//
//        Photo photo1 = new Photo();
//        photo1.setFileName("사진1");
//        photo1.setAlbum(savedAlbum);
//        photoRepository.save(photo1);
//
//
//        //when 테스트
//        AlbumDto searchedAlbum = albumService.getAlbum(Long.valueOf(16));
//        //then 사진을 1개 저장했으므로 count==1이어야한다.
//        assertEquals(searchedAlbum.getCount(), 1);
//
//    }
}