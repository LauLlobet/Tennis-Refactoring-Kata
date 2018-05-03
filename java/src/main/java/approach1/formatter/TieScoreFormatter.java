package approach1.formatter;

import approach1.ScoreFormatter;
import approach1.TennisScore;

public class TieScoreFormatter implements ScoreFormatter {

    private static final String DEUCE_TEXT = "Deuce";
    private static final String ALL_DUCE_TEXT = "-All";

    private final TennisScore tennisScore;
    private ScoreToText scoreToText = new ScoreToText();

    public TieScoreFormatter(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public String format() {
        if(tennisScore.isAPlayerScoreEqualOrMoreThanForty()) {
            return DEUCE_TEXT;
        }
        return duceForPeculiarNaming(tennisScore.getPlayer1Score());
    }

    private String duceForPeculiarNaming(Integer bothPlayersScore) {
        return scoreToText.scoreToText(bothPlayersScore) + ALL_DUCE_TEXT;
        /*

        TODO: non explicit of any implementation nor domain

         */
    }
}
