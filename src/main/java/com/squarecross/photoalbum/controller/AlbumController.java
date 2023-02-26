package com.squarecross.photoalbum.controller;

import com.squarecross.photoalbum.dto.AlbumDto;
import com.squarecross.photoalbum.request.AlbumRequest;
import com.squarecross.photoalbum.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Slf4j
@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;


    @RequestMapping(value = "/{albumId}", method= RequestMethod.GET)
    public ResponseEntity<AlbumDto> getAlbum(@PathVariable("albumId") final long albumId){
        log.info("들어옴");
        AlbumDto album = albumService.getAlbum(albumId);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ResponseEntity<AlbumDto> getAlbumById(@RequestParam(value="id")final String id){
        log.info("들어옴");
        long albumId = Long.valueOf(id);
        AlbumDto album = albumService.getAlbum(albumId);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @RequestMapping(value="/searchAndUpdate", method = RequestMethod.POST)
    public ResponseEntity<AlbumDto> getAlbumIdwithJson(@RequestBody final AlbumRequest albumRequest){
        Long albumId = albumRequest.getAlbumId();
        AlbumDto album = albumService.getAlbum(albumId);

        return new ResponseEntity<>(album, HttpStatus.OK);
    }

//    @RequestMapping(value="", method = RequestMethod.POST)
//    public ResponseEntity<AlbumDto> createAlbum(@RequestBody final AlbumRequest albumRequest){
//
//
//    }

}
