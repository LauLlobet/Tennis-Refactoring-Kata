package scoreformatters;

public class WinScoreFormatter implements scoreformatters.ScoreFormatter {
    private final String playerWithMostPoints;

    public WinScoreFormatter(String playerWithMostPoints) {
        this.playerWithMostPoints = playerWithMostPoints;
    }

    public String asString() {
        return "Win for " + playerWithMostPoints ;
    }
}
