package approach2;

public class TennisGame2 implements approach2.TennisGame {
    public int player1Points = 0;
    public int player2Points = 0;

    public String score = "Love-All";

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
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

        if (PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points)) {
            score = PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
        }

        if (isTie() && PointCall.isPointCall(player1Points)) {
            score = PointCall.fromPoints(player1Points).toString();
            score += "-All";
        }

        if (isTie() && PointCall.canBeNamedDeuceOrAdvantage(player1Points))
            score = "Deuce";

        if (isPlayer1AheadOf2() && PointCall.canBeNamedDeuceOrAdvantage(player2Points)) {
            score = "Advantage player1";
        }

        if (isPlayer2AheadOf1() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            score = "Advantage player2";
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer1AheadOf2() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            score = "Win for player1";
        }
        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer2AheadOf1() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            score = "Win for player2";
        }
    }
}