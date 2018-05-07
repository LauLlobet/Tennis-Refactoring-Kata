public class AdvantageFormatter implements ScoreFormatter {
    private final String playerWithMostPoints;

    public AdvantageFormatter(String playerWithMostPoints) {
        this.playerWithMostPoints = playerWithMostPoints;
    }

    public String asString() {
        return "Advantage " + playerWithMostPoints;
    }
}
