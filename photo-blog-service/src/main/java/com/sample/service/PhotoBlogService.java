package com.sample.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.PhotoBlogDao;
import com.sample.model.Album;
import com.sample.model.Photo;
import com.sample.model.Tag;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("service")
@Service
@Transactional
public class PhotoBlogService {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PhotoBlogDao photoBlogDao;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("albums")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Album> getAlbums(){
    	log.info("invoking getAlbums");
    	return photoBlogDao.getAlbums();
    }
    
    @GET
    @Path("album/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Photo> getAlbumPhotos(@PathParam(value = "id") long albumId){
    	log.info("invoking getPhotos for the Album id: {}",albumId);
    	return photoBlogDao.getPhotosByAlbum(albumId);
    }
    
    @GET
    @Path("photo/tags/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tag> getPhotoTags(@PathParam(value = "id") Long photoId){
    	log.info("invoking getPhotoTags for the Photo id: {}",photoId);
    	return photoBlogDao.getPhotoTags(photoId);
    }
    
    @GET
    @Path("photos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Photo> getAllPhotos(){
    	log.info("invoking getAllPhotos");
    	return photoBlogDao.getAllPhotos();
    }
}