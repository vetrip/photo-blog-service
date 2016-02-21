package com.sample.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the tags database table.
 * 
 */
@Entity
@Table(name="tags")
@ApiModel
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String name;

	//bi-directional many-to-one association to PhotoTag
	@OneToMany(mappedBy="tag")
	private List<PhotoTag> photoTags;

	public Tag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		photoTag.setTag(this);
		return photoTag;
	}

	public PhotoTag removePhotoTag(PhotoTag photoTag) {
		getPhotoTags().remove(photoTag);
		photoTag.setTag(null);

		return photoTag;
	}

}