package approach2.states;

public class TESTHandledByIfListScoreState extends ScoreState {
    public String toString(int player1Points, int player2Points) {
        return "should be handled by list of ifs";
    }

    public ScoreState nextState(int player1Points, int player2Points) {
        return new TESTHandledByIfListScoreState();
    }
}
