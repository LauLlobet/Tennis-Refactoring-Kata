package approach1.formatter;

import approach1.ScoreFormatter;
import approach1.TennisScore;

public class GameScoreFormatter implements ScoreFormatter {

    private static final String WIN_FOR_PLAYER_TEXT = "Win for ";

    private final TennisScore tennisScore;

    public GameScoreFormatter(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public String format() {
        return WIN_FOR_PLAYER_TEXT + tennisScore.playerNameWithMorePoints();
    }
}
