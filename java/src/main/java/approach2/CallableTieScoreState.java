package approach2;

public class CallableTieScoreState extends ScoreState {
    public String toString(int player1Points, int player2Points) {
        return PointCall.fromPoints(player1Points).toString() + "-" + PointCall.fromPoints(player2Points).toString();
    }
}
