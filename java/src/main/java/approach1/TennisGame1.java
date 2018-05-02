package approach1;

public class TennisGame1 implements approach1.TennisGame {
    private final TennisScore tennisScore = new TennisScore();

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
      tennisScore.wonPoint(playerName);
    }

    public String getScore() {
        ScoreFormatter scoreFormatter = ScoreFormatterFactory.makesScoreFormatter(tennisScore);
        return scoreFormatter.format();
    }
}
