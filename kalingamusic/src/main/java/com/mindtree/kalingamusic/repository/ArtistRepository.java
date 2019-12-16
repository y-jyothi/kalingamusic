package com.mindtree.kalingamusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingamusic.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
