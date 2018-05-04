package approach2;

import approach2.states.*;

public class TennisGame2 implements approach2.TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;

    private String score = "Love-All";

    private ScoreState scoreStateObj;

    public TennisGame2(String player1Name, String player2Name) {
        scoreStateObj = new CallableNoTieScoreState();
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

        scoreStateObj = scoreStateObj.nextState(player1Points,player2Points);
        score = scoreStateObj.toString(player1Points,player2Points);

        if (isCallableTieScore()) {
            /*
            Transitions to CALLABLETIE state: callableNoTie
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new CallableTieScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);

            scoreStateObj = nonTransitionedScoreStateObj;

            return;
        }

        if (isNoCallableTie()) {
            /*
            Transitions to NO_CALLABLE_TIE state: advantageP1Format
            Transitions to NO_CALLABLE_TIE state: callableNoTie
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new NoCallableTieScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreStateObj = new TESTHandledByIfListScoreState();
            return;
        }

        if (isWinP1()) {
            /*
            Transitions to WIN_P1 state: callableNoTie
            Transitions to WIN_P1 state: advantageP1Format
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new WinScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreStateObj = new TESTHandledByIfListScoreState();
            return;
        }
        if (isAdvantageP1()) {
            /*
            Transitions to ADVANTAGE_P1 state: noCallableTie
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new AdvantageP1ScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreStateObj = new TESTHandledByIfListScoreState();
            return;
        }

        if (isAdvantageP2()) {
            /*
            Transitions to ADVANTAGE_P2 state: noCallableTie
             */
            ScoreState nonTransitionedScoreStateObj;
            nonTransitionedScoreStateObj = new AdantageP2ScoreState();
            score = nonTransitionedScoreStateObj.toString(player1Points,player2Points);
            scoreStateObj = new TESTHandledByIfListScoreState();
        }


    }

    private boolean isAdvantageP2() {
        return isPlayer2AheadOf1() && PointCall.canBeNamedDeuceOrAdvantage(player1Points);
    }

    private boolean isAdvantageP1() {
        return isPlayer1AheadOf2() && PointCall.canBeNamedDeuceOrAdvantage(player2Points);
    }

    private boolean isWinP1() {
        return isMaximumPointsOfAnyPlayerAtLeast(4) && isTwoOrMoreDifferenceInPoints(player1Points, player2Points);
    }

    private boolean isNoCallableTie() {
        return isTie() && PointCall.canBeNamedDeuceOrAdvantage(player1Points);
    }

    private boolean isCallableTieScore() {
        return isTie() && !PointCall.canBeNamedDeuceOrAdvantage(player1Points);
    }

    private boolean isCallableNoTieScore() {
        return PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points) && !isTie();
    }

    private void addPointsTo(String player) {
        if (player.equals("player1")) {
            player1Points++;
        } else {
            player2Points++;
        }
    }
}