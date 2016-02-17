package com.sample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sample.model.Album;
import com.sample.model.Photo;
import com.sample.model.Tag;

@Repository
public class PhotoBlogDaoImpl implements PhotoBlogDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Album> getAlbums() {
		// TODO Auto-generated method stub
		//String qlString = "select a from Album a JOIN FETCH a.albumPhotos";
		String qlString = "select a from Album a ";
		TypedQuery<Album> createQuery = em.createQuery(qlString, Album.class);
		return createQuery.getResultList();
	}

	@Override
	public List<Photo> getAllPhotos() {
		// TODO Auto-generated method stub
		TypedQuery<Photo> namedQuery = em.createNamedQuery("Photo.findAll",Photo.class);
		return namedQuery.getResultList();
	}

	@Override
	public List<Photo> getPhotosByAlbum(Long albumId) {
		String queryString ="select p from Photo p JOIN FETCH p.albumPhotos ap where ap.album.id = :albumId ";
		TypedQuery<Photo> query = em.createQuery(queryString, Photo.class);
		query.setParameter("albumId", albumId.intValue());
		return query.getResultList();
	}

	@Override
	public List<Tag> getPhotoTags(Long photoId) {
		String queryString ="select t from Tag t JOIN FETCH t.photoTags pt where pt.photo.id = :photoId ";
		TypedQuery<Tag> query = em.createQuery(queryString, Tag.class);
		query.setParameter("photoId", photoId.intValue());
		return query.getResultList();
	}

}
