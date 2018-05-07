package scoreformatters;

public class AdvantageScoreFormatter implements scoreformatters.ScoreFormatter {
    private final String playerWithMostPoints;

    public AdvantageScoreFormatter(String playerWithMostPoints) {
        this.playerWithMostPoints = playerWithMostPoints;
    }

    public String asString() {
        return "Advantage " + playerWithMostPoints;
    }
}
