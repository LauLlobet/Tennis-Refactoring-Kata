package approach1;

public class TennisScore {
    private int player1Score = 0;
    private int player2Score = 0;

    private static final String PLAYER2_NAME = "player2";
    private static final String PLAYER1_NAME = "player1";

    private static final int THIRTY_SCORE = 2;
    private static final int FORTY_SCORE = 3;

    TennisScore() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(TennisScore.PLAYER1_NAME)) {
            player1Score = player1Score + 1;
            return;
        }
        player2Score = player2Score + 1;
    }

    public boolean isAPlayerScoreEqualOrMoreThanForty() {
        return player1Score > THIRTY_SCORE
                || player2Score > THIRTY_SCORE;
    }

    public boolean isAPlayerScoreMoreThanForty() {
        return player1Score > FORTY_SCORE
                || player2Score > FORTY_SCORE;
    }

    public boolean isAWin() {
        return isAPlayerScoreMoreThanForty() && Math.abs(player1Score - player2Score) > 1;
    }

    public String playerNameWithMorePoints() {
        if(player2Score > player1Score){
            return PLAYER2_NAME;
        }
        return PLAYER1_NAME;
    }

    public boolean isTie() {
        return player1Score == player2Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }
}