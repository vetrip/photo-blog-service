package com.sample.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;

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
@Path("/photos")
@Service
@Transactional
@Api(value="photos")
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
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value="hello" ,response = String.class)
	public String getIt() {
		return "Got it!";
	}

	@GET
	@Path("albums")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="List all albums" ,response = Album.class,
				 responseContainer = "List")
	public List<Album> getAlbums(){
		log.info("invoking getAlbums");
		return photoBlogDao.getAlbums();
	}

	@GET
	@Path("album/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Get all album photos" ,response = Photo.class,
	 responseContainer = "List")
	public List<Photo> getAlbumPhotos(@PathParam(value = "id") long albumId){
		log.info("invoking getPhotos for the Album id: {}",albumId);
		return photoBlogDao.getPhotosByAlbum(albumId);
	}

	@GET
	@Path("photo/tags/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Get photo tags" ,response = Tag.class,
	 responseContainer = "List")
	public List<Tag> getPhotoTags(@ApiParam(name="id") @PathParam(value = "id") Long photoId){
		log.info("invoking getPhotoTags for the Photo id: {}",photoId);
		return photoBlogDao.getPhotoTags(photoId);
	}

	@GET
	@Path("photos")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="Get all photos" ,response = Photo.class,
	 responseContainer = "List")
	public List<Photo> getAllPhotos(){
		log.info("invoking getAllPhotos");
		return photoBlogDao.getAllPhotos();
	}
}