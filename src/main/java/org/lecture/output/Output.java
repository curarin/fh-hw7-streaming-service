package org.lecture.output;
import org.lecture.model.Song;
import java.util.ArrayList;

public class Output {
    public void printAllSongs(ArrayList<Song> songs) {
        for (Song song : songs) {
            System.out.printf(
                    "%-35s | %-75s | #%02d: %-55s\t\t(%s)%n",
                    song.getArtist().getArtistName(),
                    song.getAlbum().getAlbumName(),
                    song.getTrackId(),
                    song.getSongTitle(),
                    song.getGenre()
            );
        }
    }

    public void printSongsByGenre(ArrayList<Song> songs) {
        System.out.printf("\n\n------ GENRE: %s ------\n", songs.getFirst().getGenre());
        for (Song song : songs) {
            System.out.printf(
                    "%-35s | %-75s | #%02d: %-55s\n",
                    song.getArtist().getArtistName(),
                    song.getAlbum().getAlbumName(),
                    song.getTrackId(),
                    song.getSongTitle()
                    );
        }
        System.out.println();
    }

    public void printSongsByStreamingCount(ArrayList<Song> songs) {
        for (Song song : songs) {
            System.out.printf(
                    "%s (on '%s'): %s (Streaming-Counter: %d)\n",
                    song.getArtist().getArtistName(),
                    song.getAlbum().getAlbumName(),
                    song.getSongTitle(),
                    song.getStreamCounter()
            );
        }
    }

    public void printTopChartSongsByGenre(ArrayList<Song> songs) {
        System.out.printf("\n\n------ GENRE: %s ------\n", songs.getFirst().getGenre());
        int position = songs.size();
        for (Song song : songs) {
            System.out.printf(
                    "Nr. %d: %s - %s (Streaming-Counter: %d)\n",
                    position,
                    song.getArtist().getArtistName(),
                    song.getSongTitle(),
                    song.getStreamCounter()
            );
            position--;
        }
        System.out.println();

    }
}
