package com.mindtree.kalingamusic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artist")
public class Artist {
	
	@Id
	@Column(name="artistId")
	private int artistId;
	
	@Column(name="artistName")
	private String artistName;
	
	@OneToMany(mappedBy="artist",cascade=CascadeType.ALL)
	private List<Song> songsList;

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artist(int artistId, String artistName, List<Song> songsList) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.songsList = songsList;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Song> getSongsList() {
		return songsList;
	}

	public void setSongsList(List<Song> songsList) {
		this.songsList = songsList;
	}

//	@Override
//	public String toString() {
//		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", songsList=" + songsList + "]";
//	}
	
	
	

}
