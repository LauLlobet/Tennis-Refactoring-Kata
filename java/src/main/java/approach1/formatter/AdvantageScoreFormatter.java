package approach1.formatter;

import approach1.ScoreFormatter;
import approach1.TennisScore;

public class AdvantageScoreFormatter implements ScoreFormatter {
    private final TennisScore tennisScore;
    private static final String ADVANTAGE_TEXT = "Advantage ";

    public AdvantageScoreFormatter(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public String format() {
        return ADVANTAGE_TEXT + tennisScore.playerNameWithMorePoints();
    }
}
