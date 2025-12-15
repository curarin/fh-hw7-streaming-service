package org.lecture.model;

public class Album {
    String albumName;
    Artist artist;

    public Album(String albumName, Artist artist) {
        this.albumName = albumName;
        this.artist = artist;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public Artist getArtist() {
        return this.artist;
    }
}
