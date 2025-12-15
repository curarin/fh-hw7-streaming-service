package org.lecture.model;

public class Artist {
    String artistName;

    public Artist(String name) {
        this.artistName = name;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
