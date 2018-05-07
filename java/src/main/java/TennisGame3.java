import scoreformatters.ScoreFormatter;

public class TennisGame3 implements TennisGame {
    private int p2;
    private int p1;

    public TennisGame3(String p1N, String p2N) {
    }

    public String getScore() {
         ScoreFormatter formatter = FormatterFactory.getFormatterFor(p1,p2);
         return formatter.asString();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
