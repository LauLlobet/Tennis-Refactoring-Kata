package approach2.states;

public class WinP1ScoreState extends ScoreState {
    public String toString(int player1Points, int player2Points) {
        return "Win for player1";
    }

    public ScoreState nextState(int player1Points, int player2Points) {
        return new TESTHandledByIfListScoreState();
    }
}
