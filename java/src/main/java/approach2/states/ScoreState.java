package approach2.states;

public abstract class ScoreState {
    public abstract String toString(int player1Points, int player2Points);

    public  abstract  ScoreState nextState(int player1Points, int player2Points);
}
