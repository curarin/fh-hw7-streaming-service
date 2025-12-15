package org.lecture.input;

import java.util.Scanner;

public class Menu {
    public int getMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int mainMenu;
        System.out.println("""
                Welcome to Streaming Charts Manager. Please select:
                ---- Song Output ----
                1 - Print all songs
                2 - Print all songs by GENRE
                3 - Print Charts (sorted) by GENRE
                4 - Print songs by Streaming Count

                ---- File Output ----
                5 - Export data
                
                ---- Misc ----
                0 - Exit
                """);
        mainMenu = scanner.nextInt();
        scanner.nextLine();
        return mainMenu;
    }

    public int getGenreMenu() {
        Scanner scanner = new Scanner(System.in);
        int genreMenu;
        System.out.println("""
                Which Genre do you want to print?
                
                1 - Rock
                2 - Pop
                3 - Indie
                4 - Nineties
                """);
        genreMenu = scanner.nextInt();
        scanner.nextLine();
        return genreMenu;
    }

    public int getStreamCounter() {
        Scanner scanner = new Scanner(System.in);
        int streamCounter;
        System.out.println("""
                What minimum streaming count would you like to print?
                """);
        streamCounter = scanner.nextInt();
        scanner.nextLine();
        return streamCounter;
    }
}
