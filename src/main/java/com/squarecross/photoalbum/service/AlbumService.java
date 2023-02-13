package com.squarecross.photoalbum.service;

import com.squarecross.photoalbum.domain.Album;
import com.squarecross.photoalbum.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.*;


@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public Album getAlbum(Long albumId){
        Optional<Album> res = albumRepository.findById(albumId);
        if(res.isPresent()){
            return res.get();
        }else{
            throw new EntityNotFoundException(String.format("앨범아이디 %d의 데이터가 없습니다.", albumId));
        }
    }

    public List<Album> getAlbumByName(String name){
        Optional<List<Album>> res = Optional.ofNullable(albumRepository.findByAlbumName(name));
        if(res.isPresent()){
            List<Album> albums = res.get();
            return albums;
        }else{
            throw new EntityNotFoundException(String.format("앨범아이디 %d의 데이터가 없습니다.", name));
        }
    }
}
