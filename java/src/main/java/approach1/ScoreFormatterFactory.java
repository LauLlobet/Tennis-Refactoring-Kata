package approach1;

import approach1.formatter.AdvantageOrGameScoreFormatter;
import approach1.formatter.NotTieAndPeculiarScoreFormatter;
import approach1.formatter.TieScoreFormatter;

public class ScoreFormatterFactory {

    public static ScoreFormatter makesScoreFormatter(TennisScore tennisScore) {
        if (tennisScore.isTie()) {
            return new TieScoreFormatter(tennisScore);
        }
        if(tennisScore.isAPlayerScoreMoreThanForty()) {
            return new AdvantageOrGameScoreFormatter(tennisScore);
        }
        return new NotTieAndPeculiarScoreFormatter(tennisScore);
    }
}
