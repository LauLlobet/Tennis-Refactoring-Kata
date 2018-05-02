package approach1.formatter;

import java.util.Hashtable;

public class ScoreToText {
    Hashtable<Integer, String> peculiarNamingForAScore = new Hashtable<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");

    }};

    public ScoreToText() {
    }

    String scoreToText(Integer score) {
        return peculiarNamingForAScore.get(score);
    }
}