public class TennisGame1 implements TennisGame {
    private int player1Score = 0;
    private int player2Score = 0;
    public static final String PLAYER1_NAME = "player1";
    ScoreFormatter scoreFormatter = new ScoreFormatter();

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1_NAME)) {
            player1Score += 1;
            return;
        }
        player2Score += 1;
    }

    public String getScore() {
        return scoreFormatter.formatScore(player1Score, player2Score);
    }
}
