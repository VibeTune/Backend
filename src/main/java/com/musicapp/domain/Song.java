package com.musicapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Song.
 */
@Entity
@Table(name = "song_table")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "track_name")
    private String trackName;

    @Column(name = "release_date")
    private Integer releaseDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "len")
    private Integer len;

    @Column(name = "dating")
    private Float dating;

    @Column(name = "violence")
    private Float violence;

    @Column(name = "world_life")
    private Float worldLife;

    @Column(name = "night_time")
    private Float nightTime;

    @Column(name = "shake_the_audience")
    private Float shakeTheAudience;

    @Column(name = "family_gospel")
    private Float familyGospel;

    @Column(name = "romantic")
    private Float romantic;

    @Column(name = "communication")
    private Float communication;

    @Column(name = "obscene")
    private Float obscene;

    @Column(name = "music")
    private Float music;

    @Column(name = "movement_places")
    private Float movementPlaces;

    @Column(name = "light_visual_perceptions")
    private Float lightVisualPerceptions;

    @Column(name = "family_spiritual")
    private Float familySpiritual;

    @Column(name = "like_girls")
    private Float likeGirls;

    @Column(name = "sadness")
    private Float sadness;

    @Column(name = "feelings")
    private Float feelings;

    @Column(name = "danceability")
    private Float danceability;

    @Column(name = "loudness")
    private Float loudness;

    @Column(name = "acousticness")
    private Float acousticness;

    @Column(name = "instrumentalness")
    private Float instrumentalness;

    @Column(name = "valence")
    private Float valence;

    @Column(name = "energy")
    private Float energy;

    @Column(name = "topic")
    private String topic;

    @Column(name = "age")
    private Float age;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Song id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public Song artistName(String artistName) {
        this.setArtistName(artistName);
        return this;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTrackName() {
        return this.trackName;
    }

    public Song trackName(String trackName) {
        this.setTrackName(trackName);
        return this;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Integer getReleaseDate() {
        return this.releaseDate;
    }

    public Song releaseDate(Integer releaseDate) {
        this.setReleaseDate(releaseDate);
        return this;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return this.genre;
    }

    public Song genre(String genre) {
        this.setGenre(genre);
        return this;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public Song lyrics(String lyrics) {
        this.setLyrics(lyrics);
        return this;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Integer getLen() {
        return this.len;
    }

    public Song len(Integer len) {
        this.setLen(len);
        return this;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public Float getDating() {
        return this.dating;
    }

    public Song dating(Float dating) {
        this.setDating(dating);
        return this;
    }

    public void setDating(Float dating) {
        this.dating = dating;
    }

    public Float getViolence() {
        return this.violence;
    }

    public Song violence(Float violence) {
        this.setViolence(violence);
        return this;
    }

    public void setViolence(Float violence) {
        this.violence = violence;
    }

    public Float getWorldLife() {
        return this.worldLife;
    }

    public Song worldLife(Float worldLife) {
        this.setWorldLife(worldLife);
        return this;
    }

    public void setWorldLife(Float worldLife) {
        this.worldLife = worldLife;
    }

    public Float getNightTime() {
        return this.nightTime;
    }

    public Song nightTime(Float nightTime) {
        this.setNightTime(nightTime);
        return this;
    }

    public void setNightTime(Float nightTime) {
        this.nightTime = nightTime;
    }

    public Float getShakeTheAudience() {
        return this.shakeTheAudience;
    }

    public Song shakeTheAudience(Float shakeTheAudience) {
        this.setShakeTheAudience(shakeTheAudience);
        return this;
    }

    public void setShakeTheAudience(Float shakeTheAudience) {
        this.shakeTheAudience = shakeTheAudience;
    }

    public Float getFamilyGospel() {
        return this.familyGospel;
    }

    public Song familyGospel(Float familyGospel) {
        this.setFamilyGospel(familyGospel);
        return this;
    }

    public void setFamilyGospel(Float familyGospel) {
        this.familyGospel = familyGospel;
    }

    public Float getRomantic() {
        return this.romantic;
    }

    public Song romantic(Float romantic) {
        this.setRomantic(romantic);
        return this;
    }

    public void setRomantic(Float romantic) {
        this.romantic = romantic;
    }

    public Float getCommunication() {
        return this.communication;
    }

    public Song communication(Float communication) {
        this.setCommunication(communication);
        return this;
    }

    public void setCommunication(Float communication) {
        this.communication = communication;
    }

    public Float getObscene() {
        return this.obscene;
    }

    public Song obscene(Float obscene) {
        this.setObscene(obscene);
        return this;
    }

    public void setObscene(Float obscene) {
        this.obscene = obscene;
    }

    public Float getMusic() {
        return this.music;
    }

    public Song music(Float music) {
        this.setMusic(music);
        return this;
    }

    public void setMusic(Float music) {
        this.music = music;
    }

    public Float getMovementPlaces() {
        return this.movementPlaces;
    }

    public Song movementPlaces(Float movementPlaces) {
        this.setMovementPlaces(movementPlaces);
        return this;
    }

    public void setMovementPlaces(Float movementPlaces) {
        this.movementPlaces = movementPlaces;
    }

    public Float getLightVisualPerceptions() {
        return this.lightVisualPerceptions;
    }

    public Song lightVisualPerceptions(Float lightVisualPerceptions) {
        this.setLightVisualPerceptions(lightVisualPerceptions);
        return this;
    }

    public void setLightVisualPerceptions(Float lightVisualPerceptions) {
        this.lightVisualPerceptions = lightVisualPerceptions;
    }

    public Float getFamilySpiritual() {
        return this.familySpiritual;
    }

    public Song familySpiritual(Float familySpiritual) {
        this.setFamilySpiritual(familySpiritual);
        return this;
    }

    public void setFamilySpiritual(Float familySpiritual) {
        this.familySpiritual = familySpiritual;
    }

    public Float getLikeGirls() {
        return this.likeGirls;
    }

    public Song likeGirls(Float likeGirls) {
        this.setLikeGirls(likeGirls);
        return this;
    }

    public void setLikeGirls(Float likeGirls) {
        this.likeGirls = likeGirls;
    }

    public Float getSadness() {
        return this.sadness;
    }

    public Song sadness(Float sadness) {
        this.setSadness(sadness);
        return this;
    }

    public void setSadness(Float sadness) {
        this.sadness = sadness;
    }

    public Float getFeelings() {
        return this.feelings;
    }

    public Song feelings(Float feelings) {
        this.setFeelings(feelings);
        return this;
    }

    public void setFeelings(Float feelings) {
        this.feelings = feelings;
    }

    public Float getDanceability() {
        return this.danceability;
    }

    public Song danceability(Float danceability) {
        this.setDanceability(danceability);
        return this;
    }

    public void setDanceability(Float danceability) {
        this.danceability = danceability;
    }

    public Float getLoudness() {
        return this.loudness;
    }

    public Song loudness(Float loudness) {
        this.setLoudness(loudness);
        return this;
    }

    public void setLoudness(Float loudness) {
        this.loudness = loudness;
    }

    public Float getAcousticness() {
        return this.acousticness;
    }

    public Song acousticness(Float acousticness) {
        this.setAcousticness(acousticness);
        return this;
    }

    public void setAcousticness(Float acousticness) {
        this.acousticness = acousticness;
    }

    public Float getInstrumentalness() {
        return this.instrumentalness;
    }

    public Song instrumentalness(Float instrumentalness) {
        this.setInstrumentalness(instrumentalness);
        return this;
    }

    public void setInstrumentalness(Float instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public Float getValence() {
        return this.valence;
    }

    public Song valence(Float valence) {
        this.setValence(valence);
        return this;
    }

    public void setValence(Float valence) {
        this.valence = valence;
    }

    public Float getEnergy() {
        return this.energy;
    }

    public Song energy(Float energy) {
        this.setEnergy(energy);
        return this;
    }

    public void setEnergy(Float energy) {
        this.energy = energy;
    }

    public String getTopic() {
        return this.topic;
    }

    public Song topic(String topic) {
        this.setTopic(topic);
        return this;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Float getAge() {
        return this.age;
    }

    public Song age(Float age) {
        this.setAge(age);
        return this;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Song)) {
            return false;
        }
        return id != null && id.equals(((Song) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Song{" +
            "id=" + getId() +
            ", artistName='" + getArtistName() + "'" +
            ", trackName='" + getTrackName() + "'" +
            ", releaseDate=" + getReleaseDate() +
            ", genre='" + getGenre() + "'" +
            ", lyrics='" + getLyrics() + "'" +
            ", len=" + getLen() +
            ", dating=" + getDating() +
            ", violence=" + getViolence() +
            ", worldLife=" + getWorldLife() +
            ", nightTime=" + getNightTime() +
            ", shakeTheAudience=" + getShakeTheAudience() +
            ", familyGospel=" + getFamilyGospel() +
            ", romantic=" + getRomantic() +
            ", communication=" + getCommunication() +
            ", obscene=" + getObscene() +
            ", music=" + getMusic() +
            ", movementPlaces=" + getMovementPlaces() +
            ", lightVisualPerceptions=" + getLightVisualPerceptions() +
            ", familySpiritual=" + getFamilySpiritual() +
            ", likeGirls=" + getLikeGirls() +
            ", sadness=" + getSadness() +
            ", feelings=" + getFeelings() +
            ", danceability=" + getDanceability() +
            ", loudness=" + getLoudness() +
            ", acousticness=" + getAcousticness() +
            ", instrumentalness=" + getInstrumentalness() +
            ", valence=" + getValence() +
            ", energy=" + getEnergy() +
            ", topic='" + getTopic() + "'" +
            ", age=" + getAge() +
            "}";
    }
}
