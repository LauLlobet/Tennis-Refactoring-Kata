package approach2.states;

public class AdantageP2ScoreState extends ScoreState {
    public String toString(int player1Points, int player2Points) {
        return "Advantage player2";
    }
    public ScoreState nextState(int player1Points, int player2Points) {
        return new TESTHandledByIfListScoreState();
    }
}
