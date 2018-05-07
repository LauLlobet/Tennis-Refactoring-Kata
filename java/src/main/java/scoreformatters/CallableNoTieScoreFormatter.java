package scoreformatters;

public class CallableNoTieScoreFormatter implements scoreformatters.ScoreFormatter {
    private final int p1;
    private final int p2;

    public CallableNoTieScoreFormatter(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String asString() {
        return CallPoint.fromPointString(p1) + "-" + CallPoint.fromPointString(p2);
    }
}
