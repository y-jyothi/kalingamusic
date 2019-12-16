package com.mindtree.kalingamusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingamusic.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}
