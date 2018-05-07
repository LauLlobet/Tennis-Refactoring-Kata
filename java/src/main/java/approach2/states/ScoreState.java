package approach2.states;

public abstract class ScoreState {
    public abstract String toString(int player1Points, int player2Points);

    public  abstract  ScoreState nextState(int player1Points, int player2Points);
    /*
    TODO: abstract class with no logic or attributes is in fact a contract which asks for a interface model, not abstract class
    TODO: having the composition of libraries that tell you the proper state is better than having them in an inheritance so interface + PointCall methods 
     */
}
