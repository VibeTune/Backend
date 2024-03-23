package com.musicapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.musicapp.IntegrationTest;
import com.musicapp.domain.Song;
import com.musicapp.repository.SongRepository;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link SongResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SongResourceIT {

    private static final String DEFAULT_ARTIST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ARTIST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TRACK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TRACK_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_RELEASE_DATE = 1;
    private static final Integer UPDATED_RELEASE_DATE = 2;

    private static final String DEFAULT_GENRE = "AAAAAAAAAA";
    private static final String UPDATED_GENRE = "BBBBBBBBBB";

    private static final String DEFAULT_LYRICS = "AAAAAAAAAA";
    private static final String UPDATED_LYRICS = "BBBBBBBBBB";

    private static final Integer DEFAULT_LEN = 1;
    private static final Integer UPDATED_LEN = 2;

    private static final Float DEFAULT_DATING = 1F;
    private static final Float UPDATED_DATING = 2F;

    private static final Float DEFAULT_VIOLENCE = 1F;
    private static final Float UPDATED_VIOLENCE = 2F;

    private static final Float DEFAULT_WORLD_LIFE = 1F;
    private static final Float UPDATED_WORLD_LIFE = 2F;

    private static final Float DEFAULT_NIGHT_TIME = 1F;
    private static final Float UPDATED_NIGHT_TIME = 2F;

    private static final Float DEFAULT_SHAKE_THE_AUDIENCE = 1F;
    private static final Float UPDATED_SHAKE_THE_AUDIENCE = 2F;

    private static final Float DEFAULT_FAMILY_GOSPEL = 1F;
    private static final Float UPDATED_FAMILY_GOSPEL = 2F;

    private static final Float DEFAULT_ROMANTIC = 1F;
    private static final Float UPDATED_ROMANTIC = 2F;

    private static final Float DEFAULT_COMMUNICATION = 1F;
    private static final Float UPDATED_COMMUNICATION = 2F;

    private static final Float DEFAULT_OBSCENE = 1F;
    private static final Float UPDATED_OBSCENE = 2F;

    private static final Float DEFAULT_MUSIC = 1F;
    private static final Float UPDATED_MUSIC = 2F;

    private static final Float DEFAULT_MOVEMENT_PLACES = 1F;
    private static final Float UPDATED_MOVEMENT_PLACES = 2F;

    private static final Float DEFAULT_LIGHT_VISUAL_PERCEPTIONS = 1F;
    private static final Float UPDATED_LIGHT_VISUAL_PERCEPTIONS = 2F;

    private static final Float DEFAULT_FAMILY_SPIRITUAL = 1F;
    private static final Float UPDATED_FAMILY_SPIRITUAL = 2F;

    private static final Float DEFAULT_LIKE_GIRLS = 1F;
    private static final Float UPDATED_LIKE_GIRLS = 2F;

    private static final Float DEFAULT_SADNESS = 1F;
    private static final Float UPDATED_SADNESS = 2F;

    private static final Float DEFAULT_FEELINGS = 1F;
    private static final Float UPDATED_FEELINGS = 2F;

    private static final Float DEFAULT_DANCEABILITY = 1F;
    private static final Float UPDATED_DANCEABILITY = 2F;

    private static final Float DEFAULT_LOUDNESS = 1F;
    private static final Float UPDATED_LOUDNESS = 2F;

    private static final Float DEFAULT_ACOUSTICNESS = 1F;
    private static final Float UPDATED_ACOUSTICNESS = 2F;

    private static final Float DEFAULT_INSTRUMENTALNESS = 1F;
    private static final Float UPDATED_INSTRUMENTALNESS = 2F;

    private static final Float DEFAULT_VALENCE = 1F;
    private static final Float UPDATED_VALENCE = 2F;

    private static final Float DEFAULT_ENERGY = 1F;
    private static final Float UPDATED_ENERGY = 2F;

    private static final String DEFAULT_TOPIC = "AAAAAAAAAA";
    private static final String UPDATED_TOPIC = "BBBBBBBBBB";

    private static final Float DEFAULT_AGE = 1F;
    private static final Float UPDATED_AGE = 2F;

    private static final String ENTITY_API_URL = "/api/songs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSongMockMvc;

    private Song song;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Song createEntity(EntityManager em) {
        Song song = new Song()
            .artistName(DEFAULT_ARTIST_NAME)
            .trackName(DEFAULT_TRACK_NAME)
            .releaseDate(DEFAULT_RELEASE_DATE)
            .genre(DEFAULT_GENRE)
            .lyrics(DEFAULT_LYRICS)
            .len(DEFAULT_LEN)
            .dating(DEFAULT_DATING)
            .violence(DEFAULT_VIOLENCE)
            .worldLife(DEFAULT_WORLD_LIFE)
            .nightTime(DEFAULT_NIGHT_TIME)
            .shakeTheAudience(DEFAULT_SHAKE_THE_AUDIENCE)
            .familyGospel(DEFAULT_FAMILY_GOSPEL)
            .romantic(DEFAULT_ROMANTIC)
            .communication(DEFAULT_COMMUNICATION)
            .obscene(DEFAULT_OBSCENE)
            .music(DEFAULT_MUSIC)
            .movementPlaces(DEFAULT_MOVEMENT_PLACES)
            .lightVisualPerceptions(DEFAULT_LIGHT_VISUAL_PERCEPTIONS)
            .familySpiritual(DEFAULT_FAMILY_SPIRITUAL)
            .likeGirls(DEFAULT_LIKE_GIRLS)
            .sadness(DEFAULT_SADNESS)
            .feelings(DEFAULT_FEELINGS)
            .danceability(DEFAULT_DANCEABILITY)
            .loudness(DEFAULT_LOUDNESS)
            .acousticness(DEFAULT_ACOUSTICNESS)
            .instrumentalness(DEFAULT_INSTRUMENTALNESS)
            .valence(DEFAULT_VALENCE)
            .energy(DEFAULT_ENERGY)
            .topic(DEFAULT_TOPIC)
            .age(DEFAULT_AGE);
        return song;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Song createUpdatedEntity(EntityManager em) {
        Song song = new Song()
            .artistName(UPDATED_ARTIST_NAME)
            .trackName(UPDATED_TRACK_NAME)
            .releaseDate(UPDATED_RELEASE_DATE)
            .genre(UPDATED_GENRE)
            .lyrics(UPDATED_LYRICS)
            .len(UPDATED_LEN)
            .dating(UPDATED_DATING)
            .violence(UPDATED_VIOLENCE)
            .worldLife(UPDATED_WORLD_LIFE)
            .nightTime(UPDATED_NIGHT_TIME)
            .shakeTheAudience(UPDATED_SHAKE_THE_AUDIENCE)
            .familyGospel(UPDATED_FAMILY_GOSPEL)
            .romantic(UPDATED_ROMANTIC)
            .communication(UPDATED_COMMUNICATION)
            .obscene(UPDATED_OBSCENE)
            .music(UPDATED_MUSIC)
            .movementPlaces(UPDATED_MOVEMENT_PLACES)
            .lightVisualPerceptions(UPDATED_LIGHT_VISUAL_PERCEPTIONS)
            .familySpiritual(UPDATED_FAMILY_SPIRITUAL)
            .likeGirls(UPDATED_LIKE_GIRLS)
            .sadness(UPDATED_SADNESS)
            .feelings(UPDATED_FEELINGS)
            .danceability(UPDATED_DANCEABILITY)
            .loudness(UPDATED_LOUDNESS)
            .acousticness(UPDATED_ACOUSTICNESS)
            .instrumentalness(UPDATED_INSTRUMENTALNESS)
            .valence(UPDATED_VALENCE)
            .energy(UPDATED_ENERGY)
            .topic(UPDATED_TOPIC)
            .age(UPDATED_AGE);
        return song;
    }

    @BeforeEach
    public void initTest() {
        song = createEntity(em);
    }

    @Test
    @Transactional
    void createSong() throws Exception {
        int databaseSizeBeforeCreate = songRepository.findAll().size();
        // Create the Song
        restSongMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(song)))
            .andExpect(status().isCreated());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeCreate + 1);
        Song testSong = songList.get(songList.size() - 1);
        assertThat(testSong.getArtistName()).isEqualTo(DEFAULT_ARTIST_NAME);
        assertThat(testSong.getTrackName()).isEqualTo(DEFAULT_TRACK_NAME);
        assertThat(testSong.getReleaseDate()).isEqualTo(DEFAULT_RELEASE_DATE);
        assertThat(testSong.getGenre()).isEqualTo(DEFAULT_GENRE);
        assertThat(testSong.getLyrics()).isEqualTo(DEFAULT_LYRICS);
        assertThat(testSong.getLen()).isEqualTo(DEFAULT_LEN);
        assertThat(testSong.getDating()).isEqualTo(DEFAULT_DATING);
        assertThat(testSong.getViolence()).isEqualTo(DEFAULT_VIOLENCE);
        assertThat(testSong.getWorldLife()).isEqualTo(DEFAULT_WORLD_LIFE);
        assertThat(testSong.getNightTime()).isEqualTo(DEFAULT_NIGHT_TIME);
        assertThat(testSong.getShakeTheAudience()).isEqualTo(DEFAULT_SHAKE_THE_AUDIENCE);
        assertThat(testSong.getFamilyGospel()).isEqualTo(DEFAULT_FAMILY_GOSPEL);
        assertThat(testSong.getRomantic()).isEqualTo(DEFAULT_ROMANTIC);
        assertThat(testSong.getCommunication()).isEqualTo(DEFAULT_COMMUNICATION);
        assertThat(testSong.getObscene()).isEqualTo(DEFAULT_OBSCENE);
        assertThat(testSong.getMusic()).isEqualTo(DEFAULT_MUSIC);
        assertThat(testSong.getMovementPlaces()).isEqualTo(DEFAULT_MOVEMENT_PLACES);
        assertThat(testSong.getLightVisualPerceptions()).isEqualTo(DEFAULT_LIGHT_VISUAL_PERCEPTIONS);
        assertThat(testSong.getFamilySpiritual()).isEqualTo(DEFAULT_FAMILY_SPIRITUAL);
        assertThat(testSong.getLikeGirls()).isEqualTo(DEFAULT_LIKE_GIRLS);
        assertThat(testSong.getSadness()).isEqualTo(DEFAULT_SADNESS);
        assertThat(testSong.getFeelings()).isEqualTo(DEFAULT_FEELINGS);
        assertThat(testSong.getDanceability()).isEqualTo(DEFAULT_DANCEABILITY);
        assertThat(testSong.getLoudness()).isEqualTo(DEFAULT_LOUDNESS);
        assertThat(testSong.getAcousticness()).isEqualTo(DEFAULT_ACOUSTICNESS);
        assertThat(testSong.getInstrumentalness()).isEqualTo(DEFAULT_INSTRUMENTALNESS);
        assertThat(testSong.getValence()).isEqualTo(DEFAULT_VALENCE);
        assertThat(testSong.getEnergy()).isEqualTo(DEFAULT_ENERGY);
        assertThat(testSong.getTopic()).isEqualTo(DEFAULT_TOPIC);
        assertThat(testSong.getAge()).isEqualTo(DEFAULT_AGE);
    }

    @Test
    @Transactional
    void createSongWithExistingId() throws Exception {
        // Create the Song with an existing ID
        song.setId(1L);

        int databaseSizeBeforeCreate = songRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restSongMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(song)))
            .andExpect(status().isBadRequest());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllSongs() throws Exception {
        // Initialize the database
        songRepository.saveAndFlush(song);

        // Get all the songList
        restSongMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(song.getId().intValue())))
            .andExpect(jsonPath("$.[*].artistName").value(hasItem(DEFAULT_ARTIST_NAME)))
            .andExpect(jsonPath("$.[*].trackName").value(hasItem(DEFAULT_TRACK_NAME)))
            .andExpect(jsonPath("$.[*].releaseDate").value(hasItem(DEFAULT_RELEASE_DATE)))
            .andExpect(jsonPath("$.[*].genre").value(hasItem(DEFAULT_GENRE)))
            .andExpect(jsonPath("$.[*].lyrics").value(hasItem(DEFAULT_LYRICS)))
            .andExpect(jsonPath("$.[*].len").value(hasItem(DEFAULT_LEN)))
            .andExpect(jsonPath("$.[*].dating").value(hasItem(DEFAULT_DATING.doubleValue())))
            .andExpect(jsonPath("$.[*].violence").value(hasItem(DEFAULT_VIOLENCE.doubleValue())))
            .andExpect(jsonPath("$.[*].worldLife").value(hasItem(DEFAULT_WORLD_LIFE.doubleValue())))
            .andExpect(jsonPath("$.[*].nightTime").value(hasItem(DEFAULT_NIGHT_TIME.doubleValue())))
            .andExpect(jsonPath("$.[*].shakeTheAudience").value(hasItem(DEFAULT_SHAKE_THE_AUDIENCE.doubleValue())))
            .andExpect(jsonPath("$.[*].familyGospel").value(hasItem(DEFAULT_FAMILY_GOSPEL.doubleValue())))
            .andExpect(jsonPath("$.[*].romantic").value(hasItem(DEFAULT_ROMANTIC.doubleValue())))
            .andExpect(jsonPath("$.[*].communication").value(hasItem(DEFAULT_COMMUNICATION.doubleValue())))
            .andExpect(jsonPath("$.[*].obscene").value(hasItem(DEFAULT_OBSCENE.doubleValue())))
            .andExpect(jsonPath("$.[*].music").value(hasItem(DEFAULT_MUSIC.doubleValue())))
            .andExpect(jsonPath("$.[*].movementPlaces").value(hasItem(DEFAULT_MOVEMENT_PLACES.doubleValue())))
            .andExpect(jsonPath("$.[*].lightVisualPerceptions").value(hasItem(DEFAULT_LIGHT_VISUAL_PERCEPTIONS.doubleValue())))
            .andExpect(jsonPath("$.[*].familySpiritual").value(hasItem(DEFAULT_FAMILY_SPIRITUAL.doubleValue())))
            .andExpect(jsonPath("$.[*].likeGirls").value(hasItem(DEFAULT_LIKE_GIRLS.doubleValue())))
            .andExpect(jsonPath("$.[*].sadness").value(hasItem(DEFAULT_SADNESS.doubleValue())))
            .andExpect(jsonPath("$.[*].feelings").value(hasItem(DEFAULT_FEELINGS.doubleValue())))
            .andExpect(jsonPath("$.[*].danceability").value(hasItem(DEFAULT_DANCEABILITY.doubleValue())))
            .andExpect(jsonPath("$.[*].loudness").value(hasItem(DEFAULT_LOUDNESS.doubleValue())))
            .andExpect(jsonPath("$.[*].acousticness").value(hasItem(DEFAULT_ACOUSTICNESS.doubleValue())))
            .andExpect(jsonPath("$.[*].instrumentalness").value(hasItem(DEFAULT_INSTRUMENTALNESS.doubleValue())))
            .andExpect(jsonPath("$.[*].valence").value(hasItem(DEFAULT_VALENCE.doubleValue())))
            .andExpect(jsonPath("$.[*].energy").value(hasItem(DEFAULT_ENERGY.doubleValue())))
            .andExpect(jsonPath("$.[*].topic").value(hasItem(DEFAULT_TOPIC)))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE.doubleValue())));
    }

    @Test
    @Transactional
    void getSong() throws Exception {
        // Initialize the database
        songRepository.saveAndFlush(song);

        // Get the song
        restSongMockMvc
            .perform(get(ENTITY_API_URL_ID, song.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(song.getId().intValue()))
            .andExpect(jsonPath("$.artistName").value(DEFAULT_ARTIST_NAME))
            .andExpect(jsonPath("$.trackName").value(DEFAULT_TRACK_NAME))
            .andExpect(jsonPath("$.releaseDate").value(DEFAULT_RELEASE_DATE))
            .andExpect(jsonPath("$.genre").value(DEFAULT_GENRE))
            .andExpect(jsonPath("$.lyrics").value(DEFAULT_LYRICS))
            .andExpect(jsonPath("$.len").value(DEFAULT_LEN))
            .andExpect(jsonPath("$.dating").value(DEFAULT_DATING.doubleValue()))
            .andExpect(jsonPath("$.violence").value(DEFAULT_VIOLENCE.doubleValue()))
            .andExpect(jsonPath("$.worldLife").value(DEFAULT_WORLD_LIFE.doubleValue()))
            .andExpect(jsonPath("$.nightTime").value(DEFAULT_NIGHT_TIME.doubleValue()))
            .andExpect(jsonPath("$.shakeTheAudience").value(DEFAULT_SHAKE_THE_AUDIENCE.doubleValue()))
            .andExpect(jsonPath("$.familyGospel").value(DEFAULT_FAMILY_GOSPEL.doubleValue()))
            .andExpect(jsonPath("$.romantic").value(DEFAULT_ROMANTIC.doubleValue()))
            .andExpect(jsonPath("$.communication").value(DEFAULT_COMMUNICATION.doubleValue()))
            .andExpect(jsonPath("$.obscene").value(DEFAULT_OBSCENE.doubleValue()))
            .andExpect(jsonPath("$.music").value(DEFAULT_MUSIC.doubleValue()))
            .andExpect(jsonPath("$.movementPlaces").value(DEFAULT_MOVEMENT_PLACES.doubleValue()))
            .andExpect(jsonPath("$.lightVisualPerceptions").value(DEFAULT_LIGHT_VISUAL_PERCEPTIONS.doubleValue()))
            .andExpect(jsonPath("$.familySpiritual").value(DEFAULT_FAMILY_SPIRITUAL.doubleValue()))
            .andExpect(jsonPath("$.likeGirls").value(DEFAULT_LIKE_GIRLS.doubleValue()))
            .andExpect(jsonPath("$.sadness").value(DEFAULT_SADNESS.doubleValue()))
            .andExpect(jsonPath("$.feelings").value(DEFAULT_FEELINGS.doubleValue()))
            .andExpect(jsonPath("$.danceability").value(DEFAULT_DANCEABILITY.doubleValue()))
            .andExpect(jsonPath("$.loudness").value(DEFAULT_LOUDNESS.doubleValue()))
            .andExpect(jsonPath("$.acousticness").value(DEFAULT_ACOUSTICNESS.doubleValue()))
            .andExpect(jsonPath("$.instrumentalness").value(DEFAULT_INSTRUMENTALNESS.doubleValue()))
            .andExpect(jsonPath("$.valence").value(DEFAULT_VALENCE.doubleValue()))
            .andExpect(jsonPath("$.energy").value(DEFAULT_ENERGY.doubleValue()))
            .andExpect(jsonPath("$.topic").value(DEFAULT_TOPIC))
            .andExpect(jsonPath("$.age").value(DEFAULT_AGE.doubleValue()));
    }

    @Test
    @Transactional
    void getNonExistingSong() throws Exception {
        // Get the song
        restSongMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingSong() throws Exception {
        // Initialize the database
        songRepository.saveAndFlush(song);

        int databaseSizeBeforeUpdate = songRepository.findAll().size();

        // Update the song
        Song updatedSong = songRepository.findById(song.getId()).get();
        // Disconnect from session so that the updates on updatedSong are not directly saved in db
        em.detach(updatedSong);
        updatedSong
            .artistName(UPDATED_ARTIST_NAME)
            .trackName(UPDATED_TRACK_NAME)
            .releaseDate(UPDATED_RELEASE_DATE)
            .genre(UPDATED_GENRE)
            .lyrics(UPDATED_LYRICS)
            .len(UPDATED_LEN)
            .dating(UPDATED_DATING)
            .violence(UPDATED_VIOLENCE)
            .worldLife(UPDATED_WORLD_LIFE)
            .nightTime(UPDATED_NIGHT_TIME)
            .shakeTheAudience(UPDATED_SHAKE_THE_AUDIENCE)
            .familyGospel(UPDATED_FAMILY_GOSPEL)
            .romantic(UPDATED_ROMANTIC)
            .communication(UPDATED_COMMUNICATION)
            .obscene(UPDATED_OBSCENE)
            .music(UPDATED_MUSIC)
            .movementPlaces(UPDATED_MOVEMENT_PLACES)
            .lightVisualPerceptions(UPDATED_LIGHT_VISUAL_PERCEPTIONS)
            .familySpiritual(UPDATED_FAMILY_SPIRITUAL)
            .likeGirls(UPDATED_LIKE_GIRLS)
            .sadness(UPDATED_SADNESS)
            .feelings(UPDATED_FEELINGS)
            .danceability(UPDATED_DANCEABILITY)
            .loudness(UPDATED_LOUDNESS)
            .acousticness(UPDATED_ACOUSTICNESS)
            .instrumentalness(UPDATED_INSTRUMENTALNESS)
            .valence(UPDATED_VALENCE)
            .energy(UPDATED_ENERGY)
            .topic(UPDATED_TOPIC)
            .age(UPDATED_AGE);

        restSongMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedSong.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedSong))
            )
            .andExpect(status().isOk());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
        Song testSong = songList.get(songList.size() - 1);
        assertThat(testSong.getArtistName()).isEqualTo(UPDATED_ARTIST_NAME);
        assertThat(testSong.getTrackName()).isEqualTo(UPDATED_TRACK_NAME);
        assertThat(testSong.getReleaseDate()).isEqualTo(UPDATED_RELEASE_DATE);
        assertThat(testSong.getGenre()).isEqualTo(UPDATED_GENRE);
        assertThat(testSong.getLyrics()).isEqualTo(UPDATED_LYRICS);
        assertThat(testSong.getLen()).isEqualTo(UPDATED_LEN);
        assertThat(testSong.getDating()).isEqualTo(UPDATED_DATING);
        assertThat(testSong.getViolence()).isEqualTo(UPDATED_VIOLENCE);
        assertThat(testSong.getWorldLife()).isEqualTo(UPDATED_WORLD_LIFE);
        assertThat(testSong.getNightTime()).isEqualTo(UPDATED_NIGHT_TIME);
        assertThat(testSong.getShakeTheAudience()).isEqualTo(UPDATED_SHAKE_THE_AUDIENCE);
        assertThat(testSong.getFamilyGospel()).isEqualTo(UPDATED_FAMILY_GOSPEL);
        assertThat(testSong.getRomantic()).isEqualTo(UPDATED_ROMANTIC);
        assertThat(testSong.getCommunication()).isEqualTo(UPDATED_COMMUNICATION);
        assertThat(testSong.getObscene()).isEqualTo(UPDATED_OBSCENE);
        assertThat(testSong.getMusic()).isEqualTo(UPDATED_MUSIC);
        assertThat(testSong.getMovementPlaces()).isEqualTo(UPDATED_MOVEMENT_PLACES);
        assertThat(testSong.getLightVisualPerceptions()).isEqualTo(UPDATED_LIGHT_VISUAL_PERCEPTIONS);
        assertThat(testSong.getFamilySpiritual()).isEqualTo(UPDATED_FAMILY_SPIRITUAL);
        assertThat(testSong.getLikeGirls()).isEqualTo(UPDATED_LIKE_GIRLS);
        assertThat(testSong.getSadness()).isEqualTo(UPDATED_SADNESS);
        assertThat(testSong.getFeelings()).isEqualTo(UPDATED_FEELINGS);
        assertThat(testSong.getDanceability()).isEqualTo(UPDATED_DANCEABILITY);
        assertThat(testSong.getLoudness()).isEqualTo(UPDATED_LOUDNESS);
        assertThat(testSong.getAcousticness()).isEqualTo(UPDATED_ACOUSTICNESS);
        assertThat(testSong.getInstrumentalness()).isEqualTo(UPDATED_INSTRUMENTALNESS);
        assertThat(testSong.getValence()).isEqualTo(UPDATED_VALENCE);
        assertThat(testSong.getEnergy()).isEqualTo(UPDATED_ENERGY);
        assertThat(testSong.getTopic()).isEqualTo(UPDATED_TOPIC);
        assertThat(testSong.getAge()).isEqualTo(UPDATED_AGE);
    }

    @Test
    @Transactional
    void putNonExistingSong() throws Exception {
        int databaseSizeBeforeUpdate = songRepository.findAll().size();
        song.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSongMockMvc
            .perform(
                put(ENTITY_API_URL_ID, song.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(song))
            )
            .andExpect(status().isBadRequest());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchSong() throws Exception {
        int databaseSizeBeforeUpdate = songRepository.findAll().size();
        song.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSongMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(song))
            )
            .andExpect(status().isBadRequest());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamSong() throws Exception {
        int databaseSizeBeforeUpdate = songRepository.findAll().size();
        song.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSongMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(song)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateSongWithPatch() throws Exception {
        // Initialize the database
        songRepository.saveAndFlush(song);

        int databaseSizeBeforeUpdate = songRepository.findAll().size();

        // Update the song using partial update
        Song partialUpdatedSong = new Song();
        partialUpdatedSong.setId(song.getId());

        partialUpdatedSong
            .artistName(UPDATED_ARTIST_NAME)
            .trackName(UPDATED_TRACK_NAME)
            .releaseDate(UPDATED_RELEASE_DATE)
            .genre(UPDATED_GENRE)
            .len(UPDATED_LEN)
            .violence(UPDATED_VIOLENCE)
            .familyGospel(UPDATED_FAMILY_GOSPEL)
            .romantic(UPDATED_ROMANTIC)
            .lightVisualPerceptions(UPDATED_LIGHT_VISUAL_PERCEPTIONS)
            .instrumentalness(UPDATED_INSTRUMENTALNESS)
            .valence(UPDATED_VALENCE)
            .topic(UPDATED_TOPIC);

        restSongMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSong.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSong))
            )
            .andExpect(status().isOk());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
        Song testSong = songList.get(songList.size() - 1);
        assertThat(testSong.getArtistName()).isEqualTo(UPDATED_ARTIST_NAME);
        assertThat(testSong.getTrackName()).isEqualTo(UPDATED_TRACK_NAME);
        assertThat(testSong.getReleaseDate()).isEqualTo(UPDATED_RELEASE_DATE);
        assertThat(testSong.getGenre()).isEqualTo(UPDATED_GENRE);
        assertThat(testSong.getLyrics()).isEqualTo(DEFAULT_LYRICS);
        assertThat(testSong.getLen()).isEqualTo(UPDATED_LEN);
        assertThat(testSong.getDating()).isEqualTo(DEFAULT_DATING);
        assertThat(testSong.getViolence()).isEqualTo(UPDATED_VIOLENCE);
        assertThat(testSong.getWorldLife()).isEqualTo(DEFAULT_WORLD_LIFE);
        assertThat(testSong.getNightTime()).isEqualTo(DEFAULT_NIGHT_TIME);
        assertThat(testSong.getShakeTheAudience()).isEqualTo(DEFAULT_SHAKE_THE_AUDIENCE);
        assertThat(testSong.getFamilyGospel()).isEqualTo(UPDATED_FAMILY_GOSPEL);
        assertThat(testSong.getRomantic()).isEqualTo(UPDATED_ROMANTIC);
        assertThat(testSong.getCommunication()).isEqualTo(DEFAULT_COMMUNICATION);
        assertThat(testSong.getObscene()).isEqualTo(DEFAULT_OBSCENE);
        assertThat(testSong.getMusic()).isEqualTo(DEFAULT_MUSIC);
        assertThat(testSong.getMovementPlaces()).isEqualTo(DEFAULT_MOVEMENT_PLACES);
        assertThat(testSong.getLightVisualPerceptions()).isEqualTo(UPDATED_LIGHT_VISUAL_PERCEPTIONS);
        assertThat(testSong.getFamilySpiritual()).isEqualTo(DEFAULT_FAMILY_SPIRITUAL);
        assertThat(testSong.getLikeGirls()).isEqualTo(DEFAULT_LIKE_GIRLS);
        assertThat(testSong.getSadness()).isEqualTo(DEFAULT_SADNESS);
        assertThat(testSong.getFeelings()).isEqualTo(DEFAULT_FEELINGS);
        assertThat(testSong.getDanceability()).isEqualTo(DEFAULT_DANCEABILITY);
        assertThat(testSong.getLoudness()).isEqualTo(DEFAULT_LOUDNESS);
        assertThat(testSong.getAcousticness()).isEqualTo(DEFAULT_ACOUSTICNESS);
        assertThat(testSong.getInstrumentalness()).isEqualTo(UPDATED_INSTRUMENTALNESS);
        assertThat(testSong.getValence()).isEqualTo(UPDATED_VALENCE);
        assertThat(testSong.getEnergy()).isEqualTo(DEFAULT_ENERGY);
        assertThat(testSong.getTopic()).isEqualTo(UPDATED_TOPIC);
        assertThat(testSong.getAge()).isEqualTo(DEFAULT_AGE);
    }

    @Test
    @Transactional
    void fullUpdateSongWithPatch() throws Exception {
        // Initialize the database
        songRepository.saveAndFlush(song);

        int databaseSizeBeforeUpdate = songRepository.findAll().size();

        // Update the song using partial update
        Song partialUpdatedSong = new Song();
        partialUpdatedSong.setId(song.getId());

        partialUpdatedSong
            .artistName(UPDATED_ARTIST_NAME)
            .trackName(UPDATED_TRACK_NAME)
            .releaseDate(UPDATED_RELEASE_DATE)
            .genre(UPDATED_GENRE)
            .lyrics(UPDATED_LYRICS)
            .len(UPDATED_LEN)
            .dating(UPDATED_DATING)
            .violence(UPDATED_VIOLENCE)
            .worldLife(UPDATED_WORLD_LIFE)
            .nightTime(UPDATED_NIGHT_TIME)
            .shakeTheAudience(UPDATED_SHAKE_THE_AUDIENCE)
            .familyGospel(UPDATED_FAMILY_GOSPEL)
            .romantic(UPDATED_ROMANTIC)
            .communication(UPDATED_COMMUNICATION)
            .obscene(UPDATED_OBSCENE)
            .music(UPDATED_MUSIC)
            .movementPlaces(UPDATED_MOVEMENT_PLACES)
            .lightVisualPerceptions(UPDATED_LIGHT_VISUAL_PERCEPTIONS)
            .familySpiritual(UPDATED_FAMILY_SPIRITUAL)
            .likeGirls(UPDATED_LIKE_GIRLS)
            .sadness(UPDATED_SADNESS)
            .feelings(UPDATED_FEELINGS)
            .danceability(UPDATED_DANCEABILITY)
            .loudness(UPDATED_LOUDNESS)
            .acousticness(UPDATED_ACOUSTICNESS)
            .instrumentalness(UPDATED_INSTRUMENTALNESS)
            .valence(UPDATED_VALENCE)
            .energy(UPDATED_ENERGY)
            .topic(UPDATED_TOPIC)
            .age(UPDATED_AGE);

        restSongMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedSong.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedSong))
            )
            .andExpect(status().isOk());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
        Song testSong = songList.get(songList.size() - 1);
        assertThat(testSong.getArtistName()).isEqualTo(UPDATED_ARTIST_NAME);
        assertThat(testSong.getTrackName()).isEqualTo(UPDATED_TRACK_NAME);
        assertThat(testSong.getReleaseDate()).isEqualTo(UPDATED_RELEASE_DATE);
        assertThat(testSong.getGenre()).isEqualTo(UPDATED_GENRE);
        assertThat(testSong.getLyrics()).isEqualTo(UPDATED_LYRICS);
        assertThat(testSong.getLen()).isEqualTo(UPDATED_LEN);
        assertThat(testSong.getDating()).isEqualTo(UPDATED_DATING);
        assertThat(testSong.getViolence()).isEqualTo(UPDATED_VIOLENCE);
        assertThat(testSong.getWorldLife()).isEqualTo(UPDATED_WORLD_LIFE);
        assertThat(testSong.getNightTime()).isEqualTo(UPDATED_NIGHT_TIME);
        assertThat(testSong.getShakeTheAudience()).isEqualTo(UPDATED_SHAKE_THE_AUDIENCE);
        assertThat(testSong.getFamilyGospel()).isEqualTo(UPDATED_FAMILY_GOSPEL);
        assertThat(testSong.getRomantic()).isEqualTo(UPDATED_ROMANTIC);
        assertThat(testSong.getCommunication()).isEqualTo(UPDATED_COMMUNICATION);
        assertThat(testSong.getObscene()).isEqualTo(UPDATED_OBSCENE);
        assertThat(testSong.getMusic()).isEqualTo(UPDATED_MUSIC);
        assertThat(testSong.getMovementPlaces()).isEqualTo(UPDATED_MOVEMENT_PLACES);
        assertThat(testSong.getLightVisualPerceptions()).isEqualTo(UPDATED_LIGHT_VISUAL_PERCEPTIONS);
        assertThat(testSong.getFamilySpiritual()).isEqualTo(UPDATED_FAMILY_SPIRITUAL);
        assertThat(testSong.getLikeGirls()).isEqualTo(UPDATED_LIKE_GIRLS);
        assertThat(testSong.getSadness()).isEqualTo(UPDATED_SADNESS);
        assertThat(testSong.getFeelings()).isEqualTo(UPDATED_FEELINGS);
        assertThat(testSong.getDanceability()).isEqualTo(UPDATED_DANCEABILITY);
        assertThat(testSong.getLoudness()).isEqualTo(UPDATED_LOUDNESS);
        assertThat(testSong.getAcousticness()).isEqualTo(UPDATED_ACOUSTICNESS);
        assertThat(testSong.getInstrumentalness()).isEqualTo(UPDATED_INSTRUMENTALNESS);
        assertThat(testSong.getValence()).isEqualTo(UPDATED_VALENCE);
        assertThat(testSong.getEnergy()).isEqualTo(UPDATED_ENERGY);
        assertThat(testSong.getTopic()).isEqualTo(UPDATED_TOPIC);
        assertThat(testSong.getAge()).isEqualTo(UPDATED_AGE);
    }

    @Test
    @Transactional
    void patchNonExistingSong() throws Exception {
        int databaseSizeBeforeUpdate = songRepository.findAll().size();
        song.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSongMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, song.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(song))
            )
            .andExpect(status().isBadRequest());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchSong() throws Exception {
        int databaseSizeBeforeUpdate = songRepository.findAll().size();
        song.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSongMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(song))
            )
            .andExpect(status().isBadRequest());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamSong() throws Exception {
        int databaseSizeBeforeUpdate = songRepository.findAll().size();
        song.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restSongMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(song)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Song in the database
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteSong() throws Exception {
        // Initialize the database
        songRepository.saveAndFlush(song);

        int databaseSizeBeforeDelete = songRepository.findAll().size();

        // Delete the song
        restSongMockMvc
            .perform(delete(ENTITY_API_URL_ID, song.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Song> songList = songRepository.findAll();
        assertThat(songList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
