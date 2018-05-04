package approach2.states;

public class WinP2ScoreState extends approach2.states.ScoreState {
    public String toString(int player1Points, int player2Points) {
        return "Win for player2";
    }

    public ScoreState nextState(int player1Points, int player2Points) {
        return new TESTHandledByIfListScoreState();
    }
}
