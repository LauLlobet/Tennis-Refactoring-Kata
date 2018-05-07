package scoreformatters;

public class CallableTieScoreFormatter implements scoreformatters.ScoreFormatter {
    private final int tiedScore;

    public CallableTieScoreFormatter(int tiedScore) {
        this.tiedScore = tiedScore;
    }

    public String asString() {
        return CallPoint.fromPointString(tiedScore)+"-All";
    }
}
