package approach2;

public class TennisGame2 implements approach2.TennisGame {
    public static final String CALLABLE_TIE = "CALLABLE_TIE";
    public static final String OTHER_STATE = "otherState";
    public int player1Points = 0;
    public int player2Points = 0;

    public String score = "Love-All";

    String state = CALLABLE_TIE;

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore() {
        return score;
    }

    private boolean isMinimumPointsOfAnyPlayerAtLeast(int points) {
        return Math.min(player1Points,player2Points) >= points;
    }

    private boolean isMaximumPointsOfAnyPlayerAtLeast(int points) {
        return Math.max(player2Points,player1Points) >= points;
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
        return Math.abs(player1Points-player2Points) >= 2;
    }

    public void wonPoint(String player) {
        if (player == "player1") {
            player1Points++;
        }else {
            player2Points++;
        }


        if(!isCallable()){
            state = OTHER_STATE;
        }

        if(state == CALLABLE_TIE){
            if (PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points) && !isTie()) {
                callableNoTieScore();
            }else {
                callableTie();
            }
            return;
        }


        if (PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points)) {
            callableNoTieScore();
        }

        if (isTie() && PointCall.isPointCall(player1Points)) {
            callableTie();
        }

        if (isTie() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            noCallableTie();
        }

        if (isPlayer1AheadOf2() && PointCall.canBeNamedDeuceOrAdvantage(player2Points)) {
            advantageP1();
        }

        if (isPlayer2AheadOf1() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            advantageP2();
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer1AheadOf2() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winP1();
        }
        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer2AheadOf1() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winP2();
        }
    }

    private void winP2() {
        score = "Win for player2";
    }

    private void winP1() {
        score = "Win for player1";
    }

    private void advantageP2() {
        score = "Advantage player2";
    }

    private void advantageP1() {
        score = "Advantage player1";
    }

    private void noCallableTie() {
        score = "Deuce";
    }

    private void callableTie() {
        score = PointCall.fromPoints(player1Points).toString();
        score += "-All";
    }

    private void callableNoTieScore() {
        score = PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
    }

    public boolean isCallable() {
        return PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points);
    }
}