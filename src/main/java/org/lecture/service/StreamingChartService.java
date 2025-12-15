package org.lecture.service;

import org.lecture.model.Genre;
import org.lecture.model.Song;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

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

    public SortedMap<Integer, Song> generateChartsByGenre(Genre genre) {
        // Konzept: Wir loopen durch alle vorhandenen Songs & speichern nur die gewünschten nach Genre weg
        // wir speichern außerdem die Streaming Counter weg und überprüfen hier, ob es Duplikate gibt
        // Duplikate werden verworfen (Check mittels Bool)
        // Anschließend bauen wir eine Sorted Map mit dem Counter als Key und dem Object als Value
        ArrayList<Song> filteredSongs = new ArrayList<>();
        ArrayList<Integer> allStreamingCounters = new ArrayList<>();
        SortedMap<Integer, Song> chartsByGenreMap = new TreeMap<>();

        for (Song song : this.allSongs) {
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
        for (Song song : filteredSongs) {
            chartsByGenreMap.put(song.getStreamCounter(), song);
        }
        return chartsByGenreMap;
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
