package approach2;

public class TennisGame2 implements approach2.TennisGame {
    public int player1Points = 0;
    public int player2Points = 0;

    public String score = "Love-All";
    public String state = "pointCallWithNoTie";

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore() {
        return score;
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

    public void incrementPoint(String player){
        if (player == "player1") {
            player1Points++;
        }else {
            player2Points++;
        }
    }

    public void wonPoint(String player) {

        incrementPoint(player);

        if(state == "pointCallWithNoTie" && ( PointCall.canBeNamedDeuceOrAdvantage(player1Points-1) || PointCall.canBeNamedDeuceOrAdvantage(player2Points-1))){
            state = "advantageOrWinOrTie";
        }

        if(state == "pointCallWithNoTie"){
            pointCallWithNoTie();
        }

        if (isTie() && PointCall.isPointCall(player1Points)) {
            pointCallWithTie();
        }

        if (isTie() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            deuce();
        }

        if (isPlayer1AheadOf2() && PointCall.canBeNamedDeuceOrAdvantage(player2Points)) {
            advantagePlayer1();
        }

        if (isPlayer2AheadOf1() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            advantagePlayer2();
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer1AheadOf2() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winPlayer1();
        }
        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer2AheadOf1() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winPlayer2();
        }
    }

    private void winPlayer2() {
        score = "Win for player2";
    }

    private void winPlayer1() {
        score = "Win for player1";
    }

    private void advantagePlayer2() {
        score = "Advantage player2";
    }

    private void advantagePlayer1() {
        score = "Advantage player1";
    }

    private void deuce() {
        score = "Deuce";
    }

    private void pointCallWithTie() {
        score = PointCall.fromPoints(player1Points).toString();
        score += "-All";
    }

    private void pointCallWithNoTie() {
        score = PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
    }
}