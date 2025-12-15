package org.lecture.model;

public class Song {
    Genre genre;
    int trackId;
    Artist artist;
    Album album;
    int streamCounter;
    String songTitle;

    public Song(Genre genre, int trackId, Artist artist, Album album, int streamCounter, String songTitle) {
        this.genre = genre;
        this.trackId = trackId;
        this.artist = artist;
        this.album = album;
        this.streamCounter = streamCounter;
        this.songTitle = songTitle;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public Album getAlbum() {
        return this.album;
    }

    public int getStreamCounter() {
        return this.streamCounter;
    }

    public String getSongTitle() {
        return this.songTitle;
    }
}
