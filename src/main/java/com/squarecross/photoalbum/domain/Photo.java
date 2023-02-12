package com.squarecross.photoalbum.domain;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity
@Table(name="photo", schema="photo_album", uniqueConstraints = {@UniqueConstraint(columnNames="album_id")})
public class Photo {


    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id", unique=true, nullable=false)
    private Long photoId;

    @Column(name = "file_name", unique=false, nullable=true)
    private String fileName;
    @Column(name = "thumb_url", unique=false, nullable=true)
    private URL thumbUrl;
    @Column(name = "original_url", unique=false, nullable=true)
    private URL originalUrl;
    @Column(name = "file_size", unique=false, nullable=true)
    private Long fileSize;
    @Column(name = "uploaded_at", unique=false, nullable=true)
    private Date uploadedAt;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }


    public Photo() {

    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public URL getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(URL thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public URL getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(URL originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }



    public Date getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Date uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
