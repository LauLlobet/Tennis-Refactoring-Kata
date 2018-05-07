public class CallableTieFormatter implements ScoreFormatter {
    private final int tiedScore;

    public CallableTieFormatter(int tiedScore) {

        this.tiedScore = tiedScore;
    }

    public String asString() {
        return CallPoint.fromPointString(tiedScore)+"-All";
    }
}
