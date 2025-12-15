package org.lecture.filehandler;

import org.lecture.model.Album;
import org.lecture.model.Artist;
import org.lecture.model.Genre;
import org.lecture.model.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileReader {
    public ArrayList<Song> readFile(String filename) {
        ArrayList<Song> songs = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src", "main", "resources", filename))) {
            String line;
            boolean headerLine = true;

            while ((line = reader.readLine()) != null) {
                if (headerLine) {
                    headerLine = false;
                    continue;
                }
                String[] values = line.split(";");
                try {
                     Genre currentGenre = Genre.valueOf(values[0].toUpperCase());
                     int currentTrackId = Integer.parseInt(values[1]);
                     Artist currentArtist = new Artist(values[2]);
                     Album currentAlbum = new Album(values[3], currentArtist);
                     String currentSongTitle = values[4];
                     int currentStreamCounter = Integer.parseInt(values[5]);
                     Song currentSong = new Song(currentGenre, currentTrackId, currentArtist, currentAlbum, currentStreamCounter, currentSongTitle);
                     songs.add(currentSong);
                } catch (Exception e) {
                    System.out.println("Fehler beim Parsen der Zeile: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
