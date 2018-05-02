package approach1;

import approach1.formatter.AdvantageScoreFormatter;
import approach1.formatter.GameScoreFormatter;
import approach1.formatter.NotTieAndPeculiarScoreFormatter;
import approach1.formatter.TieScoreFormatter;

public class ScoreFormatterFactory {

    public static ScoreFormatter makesScoreFormatter(TennisScore tennisScore) {
        if (tennisScore.isTie()) {
            return new TieScoreFormatter(tennisScore);
        }
        if(tennisScore.isAWin()){
            return new GameScoreFormatter(tennisScore);
        }
        if(tennisScore.isAPlayerScoreMoreThanForty()) {
            return new AdvantageScoreFormatter(tennisScore);
        }

        return new NotTieAndPeculiarScoreFormatter(tennisScore);
    }
}
