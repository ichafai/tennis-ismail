package com.tennis.ismail;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;



public class GameTest {

    private String PLAYER_1 = "player1";
    private String PLAYER_2 = "player2";

    @Test
    public void testQuickestGameWinP1_40_0() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testQuickestGameWinP1 = new ArrayList<>();
        testQuickestGameWinP1.add(player1); // ( 15 - 0 )
        testQuickestGameWinP1.add(player1); // ( 30 - 0 )
        testQuickestGameWinP1.add(player1); // ( 40 - 0 )
        testQuickestGameWinP1.add(player1); // => Win

        for (Player player : testQuickestGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        // THEN
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void testQuickestGameWinP2_0_40() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testQuickestGameWinP2 = new ArrayList<>();
        testQuickestGameWinP2.add(player2); // ( 0 - 15 )
        testQuickestGameWinP2.add(player2); // ( 0 - 30 )
        testQuickestGameWinP2.add(player2); // ( 0 - 40 )
        testQuickestGameWinP2.add(player2); // => Win

        for (Player player : testQuickestGameWinP2) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        // THEN
        assertEquals(player2, game.getWinner());
    }

    @Test
    public void testGameWinP1_40_30() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testGameWinP1 = new ArrayList<>();
        testGameWinP1.add(player1); // ( 15 - 0 )
        testGameWinP1.add(player2); // ( 15 - 15 )
        testGameWinP1.add(player1); // ( 30 - 15 )
        testGameWinP1.add(player2); // ( 30 - 30 )
        testGameWinP1.add(player1); // ( 40 - 30 )
        testGameWinP1.add(player1); // => Player1 Wins

        for (Player player : testGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        //THEN
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void testGameWinP2_30_40() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testGameWinP2 = new ArrayList<>();
        testGameWinP2.add(player2); // ( 0 - 15 )
        testGameWinP2.add(player1); // ( 15 - 15 )
        testGameWinP2.add(player2); // ( 15 - 30 )
        testGameWinP2.add(player1); // ( 30 - 30 )
        testGameWinP2.add(player2); // ( 30 - 40 )
        testGameWinP2.add(player2); // => Player2 Wins

        for (Player player : testGameWinP2) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        //THEN
        assertEquals(player2, game.getWinner());
    }

    @Test
    public void testGameWinP1_40_40_deuce() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testGameWinP1 = new ArrayList<>();
        testGameWinP1.add(player1); // ( 15 - 0 )
        testGameWinP1.add(player2); // ( 15 - 15 )
        testGameWinP1.add(player1); // ( 30 - 15 )
        testGameWinP1.add(player2); // ( 30 - 30 )
        testGameWinP1.add(player1); // ( 40 - 30 )
        testGameWinP1.add(player2); // ( 40 - 40 )
        testGameWinP1.add(player1); // ( ADV - 40 )
        testGameWinP1.add(player1); // => Player1 Wins

        for (Player player : testGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        //THEN
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void testGameWinP2_40_40_deuce() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testGameWinP2 = new ArrayList<>();
        testGameWinP2.add(player1); // ( 15 - 0 )
        testGameWinP2.add(player2); // ( 15 - 15 )
        testGameWinP2.add(player1); // ( 30 - 15 )
        testGameWinP2.add(player2); // ( 30 - 30 )
        testGameWinP2.add(player1); // ( 40 - 30 )
        testGameWinP2.add(player2); // ( 40 - 40 )
        testGameWinP2.add(player2); // ( 40 - ADV )
        testGameWinP2.add(player2); // => Player2 Wins

        for (Player player : testGameWinP2) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        //THEN
        assertEquals(player2, game.getWinner());
    }

    @Test
    public void testGameWinP1_40_40_deuce_extended() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testGameWinP1 = new ArrayList<>();
        testGameWinP1.add(player1); // ( 15 - 0 )
        testGameWinP1.add(player2); // ( 15 - 15 )
        testGameWinP1.add(player1); // ( 30 - 15 )
        testGameWinP1.add(player2); // ( 30 - 30 )
        testGameWinP1.add(player1); // ( 40 - 30 )
        testGameWinP1.add(player2); // ( 40 - 40 )
        testGameWinP1.add(player1); // ( ADV - 40 )
        testGameWinP1.add(player2); // ( 40 - 40 )
        testGameWinP1.add(player1); // ( ADV - 40 )
        testGameWinP1.add(player2); // ( 40 - 40 )
        testGameWinP1.add(player1); // ( ADV - 40 )
        testGameWinP1.add(player1); // => Player1 Wins

        for (Player player : testGameWinP1) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        //THEN
        assertEquals(player1, game.getWinner());
    }

    @Test
    public void testGameWinP2_40_40_deuce_extended() {

        //GIVEN
        DisplayInformationImpl displayScoresImplSystemOut = new DisplayInformationImpl();
        Player player1 = new Player(PLAYER_1);
        Player player2 = new Player(PLAYER_2);
        Game game = new Game(player1, player2);

        //WHEN
        List<Player> testGameWinP2 = new ArrayList<>();
        testGameWinP2.add(player1); // ( 15 - 0 )
        testGameWinP2.add(player2); // ( 15 - 15 )
        testGameWinP2.add(player1); // ( 30 - 15 )
        testGameWinP2.add(player2); // ( 30 - 30 )
        testGameWinP2.add(player1); // ( 40 - 30 )
        testGameWinP2.add(player2); // ( 40 - 40 )
        testGameWinP2.add(player2); // ( 40 - ADV )
        testGameWinP2.add(player1); // ( 40 - 40 )
        testGameWinP2.add(player2); // ( 40 - ADV )
        testGameWinP2.add(player1); // ( 40 - 40 )
        testGameWinP2.add(player2); // ( 40 - ADV )
        testGameWinP2.add(player2); // => Player2 Wins

        for (Player player : testGameWinP2) {
            game.incrementGameScorePlayer(player, displayScoresImplSystemOut);
            game.displayGameScore(displayScoresImplSystemOut);
        }

        //THEN
        assertEquals(player2, game.getWinner());
    }

}
