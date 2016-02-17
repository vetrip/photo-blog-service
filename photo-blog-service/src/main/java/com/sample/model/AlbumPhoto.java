package com.sample.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the album_photo database table.
 * 
 */
@Entity
@Table(name="album_photo")
@NamedQuery(name="AlbumPhoto.findAll", query="SELECT a FROM AlbumPhoto a")
public class AlbumPhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Album
	@ManyToOne
	private Album album;

	//bi-directional many-to-one association to Photo
	@ManyToOne
	private Photo photo;

	public AlbumPhoto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}