package approach1;

import approach1.formatter.AdvantageOrWinScoreFormatter;
import approach1.formatter.NotTieAndPeculiarScoreFormatter;
import approach1.formatter.TieScoreFormatter;

public class ScoreFormatterFactory {
    private static final int LAST_FOR_PECULIAR_AND_FIRST_OF_DEUCE_NAMING_SCORE = 3;

    public static ScoreFormatter makesScoreFormatter(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return new TieScoreFormatter(player1Score);
        }
        if (player1Score > LAST_FOR_PECULIAR_AND_FIRST_OF_DEUCE_NAMING_SCORE
                || player2Score > LAST_FOR_PECULIAR_AND_FIRST_OF_DEUCE_NAMING_SCORE) {
            return new AdvantageOrWinScoreFormatter(player1Score, player2Score);
        }
        return new NotTieAndPeculiarScoreFormatter(player1Score, player2Score);
    }
}
