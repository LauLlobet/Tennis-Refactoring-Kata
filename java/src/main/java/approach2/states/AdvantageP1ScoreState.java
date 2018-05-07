package approach2.states;

import approach2.PointCall;

public class AdvantageP1ScoreState extends ScoreState {
    private int player1Points;
    private int player2Points;

    public String toString(int player1Points, int player2Points) {
        return "Advantage player1";
    }
    public ScoreState nextState(int player1Points, int player2Points) {
        this.player1Points = player1Points;
        this.player2Points = player2Points;
        if(isNoCallableTie()){
            return new NoCallableTieScoreState();
        }
        return new TESTHandledByIfListScoreState();
    }

    private boolean isNoCallableTie() {
        return isTie() && PointCall.isFortyOrOver(player1Points);
    }


    private boolean isTie() {
        return player1Points == player2Points;
    }
}
