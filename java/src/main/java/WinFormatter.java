public class WinFormatter implements ScoreFormatter {
    private final String playerWithMostPoints;

    public WinFormatter(String playerWithMostPoints) {
        this.playerWithMostPoints = playerWithMostPoints;
    }

    public String asString() {
        return "Win for " + playerWithMostPoints ;
    }
}
