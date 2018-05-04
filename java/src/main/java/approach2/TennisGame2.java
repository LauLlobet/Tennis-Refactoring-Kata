package approach2;

public class TennisGame2 implements approach2.TennisGame {
    public static final String CALLABLE_TIE = "callableTie";
    public static final String CALLABLE_NO_TIE = "callableNoTie";
    public static final String NO_CALLABLE_TIE = "noCallableTie";
    public static final String WIN_P1 = "winP1Format";
    public static final String WIN_P2 = "winP2Format";
    public static final String ADVANTAGE_P1 = "advantageP1Format";
    public static final String ADVANTAGE_P2 = "advantageP2";
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

    public String state = CALLABLE_TIE;

    public void wonPoint(String player) {
        addPointsTo(player);

        if (PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points) && !isTie()) {
            System.out.println("Transitions to CALLABLENOTIE state: "+ state);
            /*
            Transitions to CALLABLENOTIE state: callableTie
            Transitions to CALLABLENOTIE state: callableNoTie
            */
            callableNoTieFormat();
            state = CALLABLE_NO_TIE;
            return;
        }

        if (isTie() && !PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            callableTieFormat();
            state = CALLABLE_TIE;
            return;
        }

        if (isTie() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            noCallableTieFormat();
            state = NO_CALLABLE_TIE;
            return;
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer1AheadOf2() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winP1Format();
            state = WIN_P1;
            return;
        }
        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer2AheadOf1() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winP2Format();
            state = WIN_P2;
            return;
        }

        if (isPlayer1AheadOf2() && PointCall.canBeNamedDeuceOrAdvantage(player2Points)) {
            advantageP1Format();
            state = ADVANTAGE_P1;
            return;
        }

        if (isPlayer2AheadOf1() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            advantageP2Format();
            state = ADVANTAGE_P2;
            return;
        }


    }

    private void addPointsTo(String player) {
        if (player == "player1") {
            player1Points++;
        }else {
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

    private void callableTieFormat() {
        score = PointCall.fromPoints(player1Points).toString();
        score += "-All";
    }

    private void callableNoTieFormat() {
        score = PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
    }
}