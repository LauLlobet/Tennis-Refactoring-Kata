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
            /*

               TODO: this method explains implementation not domain

             */
            return new AdvantageScoreFormatter(tennisScore);
        }

        return new NotTieAndPeculiarScoreFormatter(tennisScore);
    }

    /*

    TODO: try to implement it with state pattern ( transitions of a hierachy + to String)

     */
}
