package approach1.formatter;

import approach1.ScoreFormatter;
import approach1.TennisScore;

public class AdvantageOrGameScoreFormatter implements ScoreFormatter {

    public static final String ADVANTAGE_TEXT = "Advantage ";
    public static final String WIN_FOR_PLAYER_TEXT = "Win for ";

    private final TennisScore tennisScore;

    public AdvantageOrGameScoreFormatter(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public String format() {
        if (tennisScore.isAWin()) {
            return ADVANTAGE_TEXT + tennisScore.playerNameWithMorePoints();
        }
        return WIN_FOR_PLAYER_TEXT + tennisScore.playerNameWithMorePoints();
    }
}
