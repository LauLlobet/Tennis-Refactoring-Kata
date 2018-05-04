package approach2.states;

public class NoCallableTieScoreState extends ScoreState {
    public String toString(int player1Points, int player2Points) {
        return "Deuce";
    }
    public ScoreState nextState(int player1Points, int player2Points) {
        return new TESTHandledByIfListScoreState();
    }
}
