package com.mindtree.kalingamusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingamusic.dto.AlbumDto;
import com.mindtree.kalingamusic.dto.SongDto;
import com.mindtree.kalingamusic.exceptions.serviceexceptions.ServiceException;
import com.mindtree.kalingamusic.service.KalingaMusicService;

@RestController
public class KalingMusic {
	
	@Autowired
	private KalingaMusicService ser;
	
	 @PostMapping(value="/insert")
		public AlbumDto insertdata(@RequestBody AlbumDto album) {

			ser.insertAlbum(album);
			return album;

		}
	 

	 @GetMapping(value="/get/{songId}")
		public List<SongDto> getData(@PathVariable int songId) throws ServiceException {

		List<SongDto> songs=ser.getAllSongs(songId);
			return songs ;

		}
	 
	 @GetMapping(value="/getCount/{albumId}")
		public int getCount(@PathVariable int albumId) {

		
			return ser.getCountOfSongsInAlbum(albumId);

		}
	 
	 
	 

}
