package approach1.formatter;

import approach1.ScoreFormatter;
import approach1.TennisScore;

public class NotTieAndPeculiarScoreFormatter implements ScoreFormatter {
/*

        TODO: remove peculiar and find a domain name for the punctuation system

 */
    public static final String HYPHE_TEXT = "-";
    private final ScoreToText scoreToText = new ScoreToText();
    private final TennisScore tennisScore;

    public NotTieAndPeculiarScoreFormatter(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public String format() {
        return scoreToText.scoreToText(tennisScore.getPlayer1Score()) +
                HYPHE_TEXT + scoreToText.scoreToText(tennisScore.getPlayer2Score());
    }
}
