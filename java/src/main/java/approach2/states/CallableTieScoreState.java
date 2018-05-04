package approach2.states;

import approach2.PointCall;

public class CallableTieScoreState extends ScoreState {
    private int player1Points;
    private int player2Points;

    public String toString(int player1Points, int player2Points) {
        String printableScore;
        printableScore = PointCall.fromPoints(player1Points).toString();
        printableScore += "-All";
        return printableScore;
    }

    public ScoreState nextState(int player1Points, int player2Points){
        this.player1Points = player1Points;
        this.player2Points = player2Points;

        if(isCallableNoTieScore()){
            return new CallableNoTieScoreState();
        }
        return new TESTHandledByIfListScoreState();
    }

    private boolean isCallableNoTieScore() {
        return PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points) && !isTie();
    }

    private boolean isTie() {
        return player1Points == player2Points;
    }
}
