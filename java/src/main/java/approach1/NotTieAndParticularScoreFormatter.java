package approach1;

import java.util.Hashtable;

public class NotTieAndParticularScoreFormatter implements ScoreFormatter{

    public static final String HYPHE_TEXT = "-";
    private final int player1Score;
    private final int player2Score;
    private Hashtable<Integer, String> peculiarNamingForAScore = new Hashtable<Integer, String>(){{
        put(0,"Love");
        put(1,"Fifteen");
        put(2, "Thirty");
        put(3, "Forty");

    }};

    public NotTieAndParticularScoreFormatter(int player1Score, int player2Score) {

        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public String format() {
        return  peculiarNamingForAScore.get(player1Score) +
                HYPHE_TEXT + peculiarNamingForAScore.get(player2Score);
    }
}
