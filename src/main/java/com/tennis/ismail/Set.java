package com.tennis.ismail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Set {

    private static final Integer TWO = 2;

    private static final Integer FOUR = 4;

    private static final Integer FIVE = 5;

    private static final Integer SIX = 6;

    private static final Integer SEVEN = 7;

    private Player player1;

    private Player player2;

    private Game currentGame;

    private Integer setScorePlayer1;

    private Integer tieBreakScorePlayer1;

    private Integer setScorePlayer2;

    private Integer tieBreakScorePlayer2;

    private Player winner;

    Set(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        setScorePlayer1 = 0;
        tieBreakScorePlayer1 = 0;
        setScorePlayer2 = 0;
        tieBreakScorePlayer2 = 0;
        currentGame = null;
        winner = null;
    }

    Set(Match match) {
        player1 = match.getPlayer1();
        player2 = match.getPlayer2();
        setScorePlayer1 = 0;
        tieBreakScorePlayer1 = 0;
        setScorePlayer2 = 0;
        tieBreakScorePlayer2 = 0;
        currentGame = null;
        winner = null;
    }

    void play(DisplayInformation displayInformation) {
        do {
            currentGame = new Game(this);
            currentGame.play(displayInformation);
            incrementSetScorePlayer(currentGame.getWinner());
            displaySetScore(displayInformation);
        } while (winner == null);
    }

    void displaySetScore(DisplayInformation displayInformation) {
        displayInformation.displaySetScore(setScorePlayer1, setScorePlayer2);

        if (tieBreakScorePlayer1 != 0 || tieBreakScorePlayer2 != 0) {
            displayInformation.displayTieBreakScore(tieBreakScorePlayer1, tieBreakScorePlayer2);
        }

        if (winner != null) {
            announceWinner(displayInformation);
        }
    }

    private void announceWinner(DisplayInformation displayInformation) {
        if (winner != null) {
            displayInformation.displaySetWinner(winner);
        }
    }

    void incrementSetScorePlayer(Player player) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        //  Set Score is ( 5 - 4 ) or ( 4 - 5 ) leading to ( 4 - 6 ) or ( 6 - 4 ) => increment scores & designate a winner
        if ((setScorePlayer1.equals(FIVE) && setScorePlayer2 <= FOUR && player1Scoring)
                || (setScorePlayer2.equals(FIVE) && setScorePlayer1 <= FOUR && player2Scoring)) {
            incrementSetScore(player);
            designateWinner(player);
            //  Set Score is ( 6 - 6 ) => activate tie break rule
        } else if ((setScorePlayer2.equals(SIX) && setScorePlayer1.equals(SIX))) {
            activateTieBreak(player);
            //  Set Score is ( 5 - 6 ) or ( 6 - 5 ) leading to ( 5 - 7 ) or ( 7 - 5 ) => increment scores & designate a winner
        } else if ((setScorePlayer1.equals(SIX) && setScorePlayer2 <= FIVE && player1Scoring)
                || (setScorePlayer2.equals(SIX) && setScorePlayer1 <= FIVE && player2Scoring)) {
            incrementSetScore(player);
            designateWinner(player);
            // All other cases => increment set scores
        } else {
            incrementSetScore(player);
        }
    }

    private void activateTieBreak(Player player) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Increment Tie break Score
        incrementTieBreakScore(player);
        // Tie break score is at least 7 + 2 Tie break points difference => increment set scores & designate a winner
        if ((tieBreakScorePlayer1 >= SEVEN && (tieBreakScorePlayer1 >= (tieBreakScorePlayer2 + TWO)) && player1Scoring)
                || (tieBreakScorePlayer2 >= SEVEN && (tieBreakScorePlayer2 >= (tieBreakScorePlayer1 + TWO))) && player2Scoring) {

            incrementSetScore(player);
            designateWinner(player);
        }
    }

    private void designateWinner(Player player) {
        if (player1.equals(player)) {
            winner = player1;
        } else {
            winner = player2;
        }
    }

    private void incrementSetScore(Player player) {
        if (player.equals(player1)) {
            setScorePlayer1++;
        } else {
            setScorePlayer2++;
        }
    }

    private void incrementTieBreakScore(Player player) {
        if (player.equals(player1)) {
            tieBreakScorePlayer1++;
        } else {
            tieBreakScorePlayer2++;
        }
    }
}