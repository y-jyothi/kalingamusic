package com.mindtree.kalingamusic.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingamusic.dto.AlbumDto;
import com.mindtree.kalingamusic.dto.ArtistDto;
import com.mindtree.kalingamusic.dto.SongDto;
import com.mindtree.kalingamusic.entity.Album;
import com.mindtree.kalingamusic.entity.Artist;
import com.mindtree.kalingamusic.entity.Song;
import com.mindtree.kalingamusic.exceptions.errorconstants.ErrorConstants;
import com.mindtree.kalingamusic.exceptions.serviceexceptions.ServiceException;
import com.mindtree.kalingamusic.repository.AlbumRepository;
import com.mindtree.kalingamusic.repository.ArtistRepository;
import com.mindtree.kalingamusic.repository.SongRepository;
import com.mindtree.kalingamusic.service.KalingaMusicService;

@Service
public class KalingMusicImpl implements KalingaMusicService {

	ModelMapper mapper = new ModelMapper();

	@Autowired
	private AlbumRepository albumRepo;

	@Autowired
	private ArtistRepository artistRepo;

	@Autowired
	private SongRepository SongRepo;

	@Override
	public AlbumDto insertAlbum(AlbumDto album) {

		Album albums = convertDtoToEntity(album);

		List<Song> songs = new ArrayList<Song>();
		for (SongDto song : album.getSongs()) {

			Song songs1 = convertDtoToEntity(song);
			Artist artist = convertDtoToEntity(song.getArtist());
			songs1.setAlbum(albums);

			songs.add(songs1);
			songs1.setArtist(artist);

			artistRepo.saveAndFlush(artist);

		}
		albums.setSongs(songs);
		albumRepo.save(albums);

		return album;
	}

	@Override
	public List<SongDto> getAllSongs(int songId) throws ServiceException {
		Song song=null;
		Artist artist=null;
		if(!(SongRepo.existsById(songId)))
		{
			throw new ServiceException(ErrorConstants.NoSongsFound);
		}
		else
		{
		 song = SongRepo.findById(songId).get();
		artist = artistRepo.findById(song.getArtist().getArtistId()).get();
		}
		List<Song> songs = SongRepo.findAll();
		List<SongDto> songsDto = new ArrayList<SongDto>();
		for (Song song2 : songs) {
			if (song2.getArtist().getArtistId() == artist.getArtistId()) {
				AlbumDto albumDto = convertEntityToDto(song2.getAlbum());
				SongDto songDto = convertEntityToDto(song2);
				songDto.setAlbum(albumDto);
				songsDto.add(songDto);
			}
		}

		return songsDto;
	}

	@Override
	public int getCountOfSongsInAlbum(int albumId) {
		Album album = albumRepo.findById(albumId).get();
		int count = album.getSongs().size();

		return count;
	}

	private AlbumDto convertEntityToDto(Album album) {
		return mapper.map(album, AlbumDto.class);
	}

	private SongDto convertEntityToDto(Song song) {
		return mapper.map(song, SongDto.class);
	}

	private ArtistDto convertEntityToDto(Artist artist) {
		return mapper.map(artist, ArtistDto.class);
	}

	private Album convertDtoToEntity(AlbumDto albumDto) {
		return mapper.map(albumDto, Album.class);
	}

	private Song convertDtoToEntity(SongDto songDto) {
		return mapper.map(songDto, Song.class);
	}

	private Artist convertDtoToEntity(ArtistDto artistDto) {
		return mapper.map(artistDto, Artist.class);
	}

}
