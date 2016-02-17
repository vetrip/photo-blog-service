package com.sample.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the photo_tags database table.
 * 
 */
@Entity
@Table(name="photo_tags")
@NamedQuery(name="PhotoTag.findAll", query="SELECT p FROM PhotoTag p")
public class PhotoTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Photo
	@ManyToOne
	private Photo photo;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	private Tag tag;

	public PhotoTag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}