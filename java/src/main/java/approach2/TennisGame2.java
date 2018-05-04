package approach2;

public class TennisGame2 implements approach2.TennisGame {
    private static final String CALLABLE_TIE = "callableTie";
    private static final String CALLABLE_NO_TIE = "callableNoTie";
    private static final String NO_CALLABLE_TIE = "noCallableTie";
    private static final String WIN_P1 = "winP1Format";
    private static final String WIN_P2 = "winP2Format";
    private static final String ADVANTAGE_P1 = "advantageP1";
    private static final String ADVANTAGE_P2 = "advantageP2";
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

        if (PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points) && !isTie()) {
            /*
            Transitions to CALLABLENOTIE state: callableTie
            Transitions to CALLABLENOTIE state: callableNoTie
            */
            scoreStateObj = new CallableNoTieScoreState();
            score = scoreStateObj.toString(player1Points,player2Points);
            //callableNoTieFormat();
            return;
        }

        if (isTie() && !PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            /*
            Transitions to CALLABLETIE state: callableNoTie
             */
            //callableTieFormat();
            scoreStateObj = new CallableTieScoreState();
            score = scoreStateObj.toString(player1Points,player2Points);
            return;
        }

        if (isTie() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            /*
            Transitions to NO_CALLABLE_TIE state: advantageP1Format
            Transitions to NO_CALLABLE_TIE state: callableNoTie
             */
            noCallableTieFormat();
            return;
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer1AheadOf2() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            /*
            Transitions to WIN_P1 state: callableNoTie
            Transitions to WIN_P1 state: advantageP1Format
             */
            winP1Format();
            return;
        }
        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer2AheadOf1() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            /*
            Transitions to WIN_P2 state: callableNoTie
            Transitions to WIN_P2 state: advantageP2
             */
            winP2Format();
            return;
        }

        if (isPlayer1AheadOf2() && PointCall.canBeNamedDeuceOrAdvantage(player2Points)) {
            /*
            Transitions to ADVANTAGE_P1 state: noCallableTie
             */
            advantageP1Format();
            return;
        }

        if (isPlayer2AheadOf1() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            /*
            Transitions to ADVANTAGE_P2 state: noCallableTie
             */
            advantageP2Format();
        }


    }

    private void addPointsTo(String player) {
        if (player.equals("player1")) {
            player1Points++;
        } else {
            player2Points++;
        }
    }

    private void advantageP2Format() {
        score = "Advantage player2";
    }

    private void advantageP1Format() {
        score = "Advantage player1";
    }

    private void winP2Format() {
        score = "Win for player2";
    }

    private void winP1Format() {
        score = "Win for player1";
    }

    private void noCallableTieFormat() {
        score = "Deuce";
    }
}