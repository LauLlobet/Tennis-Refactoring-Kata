package approach2;

public class TennisGame2 implements approach2.TennisGame {
    public static final String NO_TIE_CALLABLE = "TIE NO NO_TIE_CALLABLE";
    public static final String NOT_INCLUDED = "NOT TESTED";
    private static final String TIE_CALLABLE = "tcc";
    private static final String DEUCE = "deuce";
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

    String state = NO_TIE_CALLABLE;

    public void wonPoint(String player) {
        if (player == "player1") {
            player1Points++;
        }else {
            player2Points++;
        }


        if(state == NO_TIE_CALLABLE && isNotCallable() || isTie()){
            if(!isMaximumPointsOfAnyPlayerAtLeast(4)) {
                state = TIE_CALLABLE;
            }
        }

        if(state == NO_TIE_CALLABLE && isMaximumPointsOfAnyPlayerAtLeast(4)){
            state = NOT_INCLUDED;
        }

        if( (state == NO_TIE_CALLABLE || state == TIE_CALLABLE) && !isTie()){
            state = NO_TIE_CALLABLE;
        }else if(isTie() && !PointCall.canBeNamedDeuceOrAdvantage(player1Points)){
            state = TIE_CALLABLE;
        }else if(isTie() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)){
            state = DEUCE;
        }else{
            state = NOT_INCLUDED;
        }

        if ( state == NO_TIE_CALLABLE) {
            noTieCallable();
            return;
        }

        if ( state == TIE_CALLABLE) {
            tieCallable();
            return;
        }

        if (state == DEUCE) {
            deuce();
            return;
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer1AheadOf2() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winP1();
            return;
        }

        if (isMaximumPointsOfAnyPlayerAtLeast(4) && isPlayer2AheadOf1() && isTwoOrMoreDifferenceInPoints(player1Points, player2Points)) {
            winP2();
            return;
        }

        if (isPlayer1AheadOf2() && PointCall.canBeNamedDeuceOrAdvantage(player2Points)) {
            advantagePlayer1();
            return;
        }

        if (isPlayer2AheadOf1() && PointCall.canBeNamedDeuceOrAdvantage(player1Points)) {
            advantageP2();
            return;
        }


    }

    private void advantageP2() {
        score = "Advantage player2";
    }

    private void advantagePlayer1() {
        score = "Advantage player1";
    }

    private void winP2() {
        score = "Win for player2";
    }

    private void winP1() {
        score = "Win for player1";
    }

    private void deuce() {
        score = "Deuce";
    }

    private void tieCallable() {
        score = PointCall.fromPoints(player1Points).toString();
        score += "-All";
    }

    private void noTieCallable() {
        score = PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
    }

    public boolean isNotCallable() {
        return !(PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points));
    }
}