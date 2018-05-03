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

        if (player1Points == player2Points && player1Points < 4) {
            score = PointCall.fromPoints(player1Points).toString();
            score += "-All";
        }


        if (player1Points == player2Points && player1Points >= 3)
            score = "Deuce";

        if (player1Points > player2Points && player2Points >= 3) {
            score = "Advantage player1";
        }

        if (player2Points > player1Points && player1Points >= 3) {
            score = "Advantage player2";
        }

        if (isPlayer1AheadOfCallsAndHisOponent() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            score = "Win for player1";
        }
        if (isPlayer2AheadOfCallsAndOfHisOponent() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            score = "Win for player2";
        }
        return score;
    }

    private boolean isPlayer1AheadOfCallsAndHisOponent() {
        return player1Points >= 4 && player1Points > player2Points;
    }

    private boolean isPlayer2AheadOfCallsAndOfHisOponent() {
        return player2Points >= 4 && player1Points < player2Points;
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