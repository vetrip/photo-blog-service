package com.sample.dao;

import java.util.List;

import com.sample.model.Album;
import com.sample.model.Photo;
import com.sample.model.Tag;

public interface PhotoBlogDao {

	public List<Album> getAlbums();
	public List<Photo> getAllPhotos();
	public List<Photo> getPhotosByAlbum(Long albumId);
	public List<Tag> getPhotoTags(Long photoId);
	
}
