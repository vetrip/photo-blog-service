package com.sample.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;



/**
 * The persistent class for the album database table.
 * 
 */
@Entity
@ApiModel
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String desc;

	private String name;

	//bi-directional many-to-one association to AlbumPhoto
	@OneToMany(mappedBy="album")
	private List<AlbumPhoto> albumPhotos;

	public Album() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
		albumPhoto.setAlbum(this);

		return albumPhoto;
	}

	public AlbumPhoto removeAlbumPhoto(AlbumPhoto albumPhoto) {
		getAlbumPhotos().remove(albumPhoto);
		albumPhoto.setAlbum(null);

		return albumPhoto;
	}

}