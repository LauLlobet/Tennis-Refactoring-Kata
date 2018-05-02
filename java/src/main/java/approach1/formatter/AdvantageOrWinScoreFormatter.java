package approach1.formatter;

import approach1.ScoreFormatter;

public class AdvantageOrWinScoreFormatter implements ScoreFormatter {

    public static final String ADVANTAGE_TEXT = "Advantage ";
    public static final String WIN_FOR_PLAYER_TEXT = "Win for ";
    public static final int ADVANTAGE_POINT = 1;
    public static final String PLAYER2_NAME = "player2";
    public static final String PLAYER1_NAME = "player1";

    private final int player1Score;
    private final int player2Score;

    public AdvantageOrWinScoreFormatter(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public String format() {
        int minusResult = Math.abs(player1Score - player2Score);
        if (minusResult == ADVANTAGE_POINT) {
            return ADVANTAGE_TEXT + playerNameWithMorePoints(player1Score, player2Score);
        }
        return WIN_FOR_PLAYER_TEXT + playerNameWithMorePoints(player1Score, player2Score);
    }

    private String playerNameWithMorePoints(int p1s, int p2s) {
        if(p1s > p2s){
            return PLAYER1_NAME;
        }
        return PLAYER2_NAME;
    }
}
