package approach1.formatter;

import java.util.Hashtable;
import java.util.Map;

public class ScoreToText {
    Map<Integer, String> peculiarNamingForAScore = new Hashtable<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");

    }};
    /*

    TODO: move to enum so domain is modeled

     */

    String scoreToText(Integer score) {
        return peculiarNamingForAScore.get(score);
    }
}