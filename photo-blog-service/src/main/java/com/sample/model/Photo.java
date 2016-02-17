package com.sample.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the photo database table.
 * 
 */
@Entity
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private byte[] content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String desc;

	private String name;

	//bi-directional many-to-one association to AlbumPhoto
	@OneToMany(mappedBy="photo")
	private List<AlbumPhoto> albumPhotos;

	//bi-directional many-to-one association to PhotoTag
	@OneToMany(mappedBy="photo")
	private List<PhotoTag> photoTags;

	public Photo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public List<AlbumPhoto> getAlbumPhotos() {
		return this.albumPhotos;
	}

	public void setAlbumPhotos(List<AlbumPhoto> albumPhotos) {
		this.albumPhotos = albumPhotos;
	}

	public AlbumPhoto addAlbumPhoto(AlbumPhoto albumPhoto) {
		getAlbumPhotos().add(albumPhoto);
		albumPhoto.setPhoto(this);

		return albumPhoto;
	}

	public AlbumPhoto removeAlbumPhoto(AlbumPhoto albumPhoto) {
		getAlbumPhotos().remove(albumPhoto);
		albumPhoto.setPhoto(null);

		return albumPhoto;
	}
	
	@XmlTransient
	public List<PhotoTag> getPhotoTags() {
		return this.photoTags;
	}

	public void setPhotoTags(List<PhotoTag> photoTags) {
		this.photoTags = photoTags;
	}

	public PhotoTag addPhotoTag(PhotoTag photoTag) {
		getPhotoTags().add(photoTag);
		photoTag.setPhoto(this);

		return photoTag;
	}

	public PhotoTag removePhotoTag(PhotoTag photoTag) {
		getPhotoTags().remove(photoTag);
		photoTag.setPhoto(null);

		return photoTag;
	}

}