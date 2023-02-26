package com.squarecross.photoalbum.service;

import com.squarecross.photoalbum.domain.Album;
import com.squarecross.photoalbum.dto.AlbumDto;
import com.squarecross.photoalbum.mapper.AlbumMapper;
import com.squarecross.photoalbum.repository.AlbumRepository;
import com.squarecross.photoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.*;


@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;

    public AlbumDto getAlbum(Long albumId){
        Optional<Album> res = albumRepository.findById(albumId);
        if(res.isPresent()){
            AlbumDto albumDto = AlbumMapper.convertToDto(res.get());
            albumDto.setCount(photoRepository.countByAlbum_AlbumId(albumId));
            return albumDto;
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

    //albumdto 객체를 album 객체로 반환한다.
    //album 객체를 db에 저장한다.
    //photos/original, photos/thumbnail 디렉토리 내 신규 앨범 디렉토리 생성
    //생성한 앨범 정보 dto로 변환하여 controller에 출력함

}
