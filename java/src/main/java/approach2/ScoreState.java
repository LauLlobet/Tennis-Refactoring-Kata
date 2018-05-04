package approach2;

public abstract class ScoreState {
    public abstract String toString(int player1Points, int player2Points);

    public ScoreState nextState(int player1Points, int player2Points){
        return new InconsistendStateScore();
    }
}
