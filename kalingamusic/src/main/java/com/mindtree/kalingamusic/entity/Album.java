package com.mindtree.kalingamusic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Album")
public class Album {
	
	@Id
	@Column(name="albumId")
	private int albumId;
	
	@Column(name="albumName")
	private String albumName;
	
	@OneToMany(mappedBy="album",cascade=CascadeType.ALL)
	private List<Song> songs;
	
//	@Override
//	public String toString() {
//		return "Album [albumId=" + albumId + ", albumName=" + albumName + ", songs=" + songs + "]";
//	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Album(int albumId, String albumName, List<Song> songs) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.songs = songs;
	}

	

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
