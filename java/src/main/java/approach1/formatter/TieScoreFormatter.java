package approach1.formatter;

import approach1.ScoreFormatter;

import java.util.Hashtable;

public class TieScoreFormatter implements ScoreFormatter {

    private static final int LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE = 3;
    private static final String DEUCE_TEXT = "Deuce";
    private static final String ALL_DUCE_TEXT = "-All";
    private final int bothPlayersScore;
    private ScoreToText scoreToText = new ScoreToText();

    public TieScoreFormatter(int bothPlayerScore) {
        this.bothPlayersScore = bothPlayerScore;
    }

    public String format() {
            if(isPeculiarNamingScore()){
                return duceForPeculiarNaming(bothPlayersScore);
            }
            return DEUCE_TEXT;
    }

    private boolean isPeculiarNamingScore() {
        return bothPlayersScore < LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE;
    }

    private String duceForPeculiarNaming(Integer bothPlayersScore) {
        return  scoreToText.scoreToText(bothPlayersScore)+ ALL_DUCE_TEXT;
    }
}
