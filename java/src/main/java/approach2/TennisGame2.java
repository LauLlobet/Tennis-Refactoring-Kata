package approach2;

public class TennisGame2 implements approach2.TennisGame {
    public int player1Points = 0;
    public int player2Points = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        if (PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points)) {
            score = PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
        }

        if (isTie() && player1Points < 4) {
            score = PointCall.fromPoints(player1Points).toString();
            score += "-All";
        }


        if (isTie() && isMinimumPointsOfAnyPlayerAtLeast(3))
            score = "Deuce";

        if (isPlayer1AheadOf2() && isMinimumPointsOfAnyPlayerAtLeast(3)) {
            score = "Advantage player1";
        }

        if (isPlayer2AheadOf1() && isMinimumPointsOfAnyPlayerAtLeast(3)) {
            score = "Advantage player2";
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer1AheadOf2() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            score = "Win for player1";
        }
        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer2AheadOf1() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            score = "Win for player2";
        }
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
            return;
        }
        player2Points++;
    }
}