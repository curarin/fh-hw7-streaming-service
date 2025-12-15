package org.lecture.service;

import org.lecture.model.Genre;
import org.lecture.model.Song;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamingChartService {
    ArrayList<Song> allSongs;

    public StreamingChartService(ArrayList<Song> allSongs) {
        this.allSongs = allSongs;
    }

    public ArrayList<Song> generateSongsByGenre(Genre genre) {
        ArrayList<Song> filteredSongs = new ArrayList<>();

        for (Song song : allSongs) {
            if (song.getGenre().equals(genre)) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

    public ArrayList<Song> generateChartsByGenre(Genre genre) {
        // Gefragt ist eigentlich eine Sorted Map
        // MVP machen wir mal so, wenn noch Zeit ist wirds refactored
        ArrayList<Song> filteredSongs = new ArrayList<>();
        ArrayList<Integer> allStreamingCounters = new ArrayList<>();

        for (Song song : allSongs) {
            boolean songAlreadyExists = false;
            if (song.getGenre().equals(genre)) {
                for (Integer allStreamingCounter : allStreamingCounters) {
                    if (song.getStreamCounter() == allStreamingCounter) {
                        System.err.printf(
                                "SKIPPED due to same Streaming Counter --> %d | %s | %s | %s | %s | %d\n",
                                song.getTrackId(),
                                song.getSongTitle(),
                                song.getArtist().getArtistName(),
                                song.getAlbum().getAlbumName(),
                                song.getGenre(),
                                song.getStreamCounter()
                        );
                        songAlreadyExists = true;
                    }
                }
                if (!songAlreadyExists) {
                    filteredSongs.add(song);
                    allStreamingCounters.add(song.getStreamCounter());
                }
            }
        }
        filteredSongs.sort(Comparator.comparingInt(Song::getStreamCounter));
        return filteredSongs;
    }

    public ArrayList<Song> generateChartsByStreamingCount(int count) {
        ArrayList<Song> filteredSongs = new ArrayList<>();
        for (Song song : allSongs) {
            if (song.getStreamCounter() >= count) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }
}
