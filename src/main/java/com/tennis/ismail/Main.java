package com.tennis.ismail;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //  DisplayInformation Instantiation
        DisplayInformation displayScoresImplSystemOut = new DisplayInformationImpl();

        // Display opening banner
        displayScoresImplSystemOut.displayOpeningBanner();

        // Player1 Instantiation
        Scanner scannerInPlayer1 = new Scanner(System.in);
        System.out.print("Please enter a username for player1: ");
        String player1Username = scannerInPlayer1.nextLine();
        Player player1 = new Player(player1Username);

        // Player2 Instantiation
        Scanner scannerInPlayer2 = new Scanner(System.in);
        System.out.print("Please enter a username for player2: ");
        String player2Username = scannerInPlayer2.nextLine();
        Player player2 = new Player(player2Username);

        Match match = new Match(player1, player2);
        match.play(displayScoresImplSystemOut);

        // Display closing banner
        displayScoresImplSystemOut.displayClosingBanner();
    }
}
