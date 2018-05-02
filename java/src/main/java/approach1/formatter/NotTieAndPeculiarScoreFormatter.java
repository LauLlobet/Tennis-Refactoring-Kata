package approach1.formatter;

import approach1.ScoreFormatter;

public class NotTieAndPeculiarScoreFormatter implements ScoreFormatter {

    public static final String HYPHE_TEXT = "-";
    private final int player1Score;
    private final int player2Score;
    private final ScoreToText scoreToText = new ScoreToText();

    public NotTieAndPeculiarScoreFormatter(int player1Score, int player2Score) {

        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public String format() {
        return scoreToText.scoreToText(player1Score) +
                HYPHE_TEXT + scoreToText.scoreToText(player2Score);
    }
}
