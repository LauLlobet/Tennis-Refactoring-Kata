package approach1;

public class TennisScore {
    int player1Score = 0;
    int player2Score = 0;

    public static final String PLAYER2_NAME = "player2";
    public static final String PLAYER1_NAME = "player1";
    static final int MAX_SCORE_WITHOUT_A_WIN_CHANCE = 3;

    public TennisScore() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(TennisScore.PLAYER1_NAME)) {
            player1Score = player1Score + 1;
            return;
        }
        player2Score = player2Score + 1;
    }

    public boolean isAPlayerScoreMoreThanThirty() {
        return player1Score >= MAX_SCORE_WITHOUT_A_WIN_CHANCE
                || player2Score >= MAX_SCORE_WITHOUT_A_WIN_CHANCE;
    }

    public boolean isAPlayerScoreMoreThanForty() {
        return player1Score > MAX_SCORE_WITHOUT_A_WIN_CHANCE
                || player2Score > MAX_SCORE_WITHOUT_A_WIN_CHANCE;
    }

    public boolean isAWin() {
        return isAPlayerScoreMoreThanForty() && Math.abs(player1Score - player2Score) == 1;
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