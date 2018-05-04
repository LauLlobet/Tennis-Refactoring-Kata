package approach2.states;

public class WinScoreState extends ScoreState {
    public String toString(int player1Points, int player2Points) {
        if(isPlayer1AheadOf2(player1Points,player2Points)) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private boolean isPlayer1AheadOf2(int player1Points, int player2Points) {
        return player1Points > player2Points;
    }

    public ScoreState nextState(int player1Points, int player2Points) {
        return new TESTHandledByIfListScoreState();
    }
}
