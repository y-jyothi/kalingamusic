package com.mindtree.kalingamusic.service;

import java.util.List;

import com.mindtree.kalingamusic.dto.AlbumDto;
import com.mindtree.kalingamusic.dto.SongDto;
import com.mindtree.kalingamusic.exceptions.serviceexceptions.ServiceException;

public interface KalingaMusicService {
	public AlbumDto insertAlbum(AlbumDto album);
	public List<SongDto> getAllSongs(int songId) throws ServiceException;
	public int getCountOfSongsInAlbum(int albumId);

}
