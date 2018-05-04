package approach2;

public class CallableNoTieScoreState extends ScoreState {
    private int player2Points;
    private int player1Points;

    public String toString(int player1Points, int player2Points) {
        return PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
    }

    public ScoreState nextState(int player1Points, int player2Points){
        this.player1Points = player1Points;
        this.player2Points = player2Points;

        if(isCallableNoTieScore()){
            return new CallableNoTieScoreState();
        }
        return new InconsistendStateScore();
    }

    private boolean isCallableNoTieScore() {
        return PointCall.isPointCall(player2Points) && PointCall.isPointCall(player1Points) && !isTie();
    }

    private boolean isTie() {
        return player1Points == player2Points;
    }
}