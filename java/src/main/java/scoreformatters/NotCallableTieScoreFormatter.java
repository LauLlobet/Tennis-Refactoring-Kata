package scoreformatters;

public class NotCallableTieScoreFormatter implements scoreformatters.ScoreFormatter {
    public NotCallableTieScoreFormatter() {
    }

    public String asString() {
        return "Deuce";
    }
}