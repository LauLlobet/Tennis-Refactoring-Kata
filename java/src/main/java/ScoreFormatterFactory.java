import java.util.Hashtable;

public class ScoreFormatterFactory {
    public static final int LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE = 3;

    public static ScoreFormatter makesScoreFormatter(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return new TieScoreFormatter(player1Score);
        }
        if (player1Score > LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE
                || player2Score > LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE) {
            return new AdvantageOrWinScoreFormatter(player1Score, player2Score);
        }
        return new NotTieAndParticularScoreFormatter(player1Score, player2Score);
    }
}

/*
3 3 -> DUCE
2 2 -> THIRTY ALL
1 2 -> FIFTEEN THIRTY
2 3 -> THRTY FOURTEE
3 4  -> ADVANTAGE FOR PLAYER
*/
