package approach2;

public class CallableTieScoreState extends ScoreState {
    public String toString(int player1Points, int player2Points) {
        String printableScore;
        printableScore = PointCall.fromPoints(player1Points).toString();
        printableScore += "-All";
        return printableScore;
    }
}
