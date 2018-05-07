package approach2;

import approach2.states.*;

public class TennisGame2 implements approach2.TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;

    private String score = "Love-All";

    private ScoreState scoreState;

    public TennisGame2(String player1Name, String player2Name) {
        scoreState = new CallableNoTieScoreState();
    }

    public String getScore() {
        return score;
    }

    private boolean isMaximumPointsOfAnyPlayerAtLeast(int points) {
        return Math.max(player2Points, player1Points) >= points;
    }

    private boolean isTie() {
        return player1Points == player2Points;
    }

    private boolean isPlayer1AheadOf2() {
        return player1Points > player2Points;
    }

    private boolean isPlayer2AheadOf1() {
        return player1Points < player2Points;
    }

    private boolean isTwoOrMoreDifferenceInPoints(int player1Points, int player2Points) {
        return Math.abs(player1Points - player2Points) >= 2;
    }

    public void wonPoint(String player) {

        addPointsTo(player);

        scoreState = scoreState.nextState(player1Points,player2Points);
        score = scoreState.toString(player1Points,player2Points);


        /* TODO: if all ifs are moved into a intitiall state you don't have a competition of both states (if+statpattern)
        TODO: if the state score is moved into a state class and not passed along as a parameter, it can disappeare easily .
         */

        if (isWinP1()) {
            /*
            Transitions to WIN_P1 state: advantageP1Format
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new WinP1ScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreState = new TESTHandledByIfListScoreState();
            return;
        }
        if (isWinP2()) {
            /*
            Transitions to WIN_P1 state: advantageP1Format
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new WinP2ScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreState = new TESTHandledByIfListScoreState();
            return;
        }
        if (isAdvantageP1()) {
            /*
            Transitions to ADVANTAGE_P1 state: noCallableTie
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new AdvantageP1ScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreState = nonTransitionedScoreStateObj;
            return;
        }

        if (isAdvantageP2()) {
            /*
            Transitions to ADVANTAGE_P2 state: noCallableTie
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new AdantageP2ScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreState = new TESTHandledByIfListScoreState();
        }


    }

    private boolean isAdvantageP2() {
        return isPlayer2AheadOf1() && PointCall.isFortyOrOver(player1Points);
    }

    private boolean isAdvantageP1() {
        return isPlayer1AheadOf2() && PointCall.isFortyOrOver(player2Points);
    }

    private boolean isWinP1() {
        return isMaximumPointsOfAnyPlayerAtLeast(4) && isTwoOrMoreDifferenceInPoints(player1Points, player2Points) && isPlayer1AheadOf2();
    }

    private boolean isWinP2() {
        return isMaximumPointsOfAnyPlayerAtLeast(4) && isTwoOrMoreDifferenceInPoints(player1Points, player2Points) && isPlayer2AheadOf1();
    }

    private boolean isNoCallableTie() {
        return isTie() && PointCall.isFortyOrOver(player1Points);
    }


    private void addPointsTo(String player) {
        if (player.equals("player1")) {
            player1Points++;
        } else {
            player2Points++;
        }
    }
}