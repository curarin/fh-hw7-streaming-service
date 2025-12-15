package org.lecture.filehandler;

import org.lecture.model.Genre;
import org.lecture.model.Song;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileWriter {
    public void writeFile(ArrayList<Song> songs, Genre genre) throws IOException {
        Path path = Paths.get("src", "main", "resources", "exam", genre + "/", "songs.txt");
        ArrayList<Song> filteredSongs = new ArrayList<>();
        if (Files.notExists(path)) {
            Files.createDirectories(path.getParent());
        }

        for (Song song : songs) {
            if (song.getGenre().equals(genre)) {
                filteredSongs.add(song);
            }
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Song song : filteredSongs) {
                if (song.getStreamCounter() < 50) {
                    writeData(song, bw);
                    bw.newLine();
                } else {
                    bw.write("<strong>");
                    bw.newLine();
                    writeData(song, bw);
                    bw.write("</strong>");
                    bw.newLine();
                    bw.newLine();
                }
            }
        }
        System.out.printf(
                "File successfully written to '%s'.\n",
                path)
        ;
    }

    private static void writeData(Song song, BufferedWriter bw) throws IOException {
        bw.write(String.format("Artist: %s\n", song.getArtist().getArtistName()));
        bw.write(String.format("Album: %s\n", song.getAlbum().getAlbumName()));
        bw.write(String.format("\tSong# %02d\n", song.getTrackId()));
        bw.write(String.format("\t\tSong: %s\n", song.getSongTitle()));
        bw.write(String.format("Stream-Counter: %02d\n", song.getStreamCounter()));
    }
}
