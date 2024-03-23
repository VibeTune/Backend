package com.musicapp.repository;

import com.musicapp.domain.Song;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Song entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SongRepository extends JpaRepository<Song, Long> {}
