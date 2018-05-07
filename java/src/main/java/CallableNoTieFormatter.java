public class CallableNoTieFormatter implements ScoreFormatter {
    private final int p1;
    private final int p2;

    public CallableNoTieFormatter(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String asString() {
        return CallPoint.fromPointString(p1) + "-" + CallPoint.fromPointString(p2);
    }
}
