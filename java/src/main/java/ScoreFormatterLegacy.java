import java.util.Hashtable;

public class ScoreFormatterLegacy {
    public static final int LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE = 3;


    public String formatScore(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            TieScoreFormatter score = new TieScoreFormatter(player1Score);
            return score.format();
        }
        if (player1Score > LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE
                || player2Score > LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE) {
            AdvantageOrWinScoreFormatter score = new AdvantageOrWinScoreFormatter(player1Score, player2Score);
            return score.format();
        }
        ScoreFormatter formatter = new NotTieAndParticularScoreFormatter(player1Score, player2Score);
        return formatter.format();
    }





}

/*
3 3 -> DUCE
2 2 -> THIRTY ALL
1 2 -> FIFTEEN THIRTY
2 3 -> THRTY FOURTEE
3 4  -> ADVANTAGE FOR PLAYER
*/
