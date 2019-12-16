package com.mindtree.kalingamusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingamusic.entity.Album;

@Repository
 public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
