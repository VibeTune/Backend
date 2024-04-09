package com.musicapp.responseFormatter;

// SongInfo.java

public class SongInfo {
    private String song;
    private String artist;

    public SongInfo(String song, String artist) {
        this.song = song;
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public String getArtist() {
        return artist;
    }
}
