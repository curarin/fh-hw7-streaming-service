package org.lecture.application;

import org.lecture.filehandler.FileReader;
import org.lecture.filehandler.FileWriter;
import org.lecture.input.Menu;
import org.lecture.model.Genre;
import org.lecture.model.Song;
import org.lecture.output.Output;
import org.lecture.service.StreamingChartService;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        Menu menu = new Menu();
        FileWriter fileWriter = new FileWriter();
        Output output = new Output();
        ArrayList<Song> allSongs = fileReader.readFile("streaming.csv");
        StreamingChartService charts = new StreamingChartService(allSongs);
        boolean isRunning = true;

        do {
            int mainMenu = menu.getMainMenu();

            switch (mainMenu) {
                case 1 -> output.printAllSongs(allSongs);
                case 2 -> {
                    int genreMenuInput = menu.getGenreMenu();
                    switch (genreMenuInput) {
                        case 1 -> output.printSongsByGenre(charts.generateChartsByGenre(Genre.ROCK));
                        case 2 -> output.printSongsByGenre(charts.generateChartsByGenre(Genre.POP));
                        case 3 -> output.printSongsByGenre(charts.generateChartsByGenre(Genre.INDIE));
                        case 4 -> output.printSongsByGenre(charts.generateChartsByGenre(Genre.NINETIES));
                    }
                }
                case 3 -> {
                    int genreMenuInput = menu.getGenreMenu();
                    switch (genreMenuInput) {
                        case 1 -> output.printTopChartSongsByGenre(charts.generateChartsByGenre(Genre.ROCK));
                        case 2 -> output.printTopChartSongsByGenre(charts.generateChartsByGenre(Genre.POP));
                        case 3 -> output.printTopChartSongsByGenre(charts.generateChartsByGenre(Genre.INDIE));
                        case 4 -> output.printTopChartSongsByGenre(charts.generateChartsByGenre(Genre.NINETIES));
                    }
                }
                case 4 -> {
                    int streamingCountMenuInput = menu.getStreamCounter();
                    output.printSongsByStreamingCount(charts.generateChartsByStreamingCount(streamingCountMenuInput));
                }
                case 5 -> {
                    int genreMenuInput = menu.getGenreMenu();
                    switch (genreMenuInput) {
                        case 1 -> fileWriter.writeFile(allSongs, Genre.ROCK);
                        case 2 -> fileWriter.writeFile(allSongs, Genre.POP);
                        case 3 -> fileWriter.writeFile(allSongs, Genre.INDIE);
                        case 4 -> fileWriter.writeFile(allSongs, Genre.NINETIES);
                    }
                }
                case 0 -> isRunning = false;
                default -> {
                    System.out.println("Invalid menu option");
                }
            } }
        while (isRunning) ;
        }
    }
