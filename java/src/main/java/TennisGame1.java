import java.util.Hashtable;

public class TennisGame1 implements TennisGame {

    public static final String ADVANTAGE_TEXT = "Advantage ";
    public static final String WIN_FOR_TEXT = "Win for ";
    public static final String HYPHE_TEXT = "-";
    public static final String DEUCE_TEXT = "Deuce";
    public static final String PLAYER2_TEXT = "player2";
    public static final String PLAYER1 = "player1";
    public static final String PLAYER1_TEXT = "player1";
    private int player1Score = 0;
    private int player2Score = 0;

    private Hashtable<Integer, String> aliasOfScores = new Hashtable<Integer, String>(){{
        put(0,"Love");
        put(1,"Fifteen");
        put(2, "Thirty");
        put(3, "Forty");

    }};

    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName == PLAYER1_TEXT) {
            player1Score += 1;
            return;
        }
        player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score)
        {
            return tieCases(player1Score);
        }
        if (player1Score >=4 || player2Score >=4)
        {
            return overFourCases();
        }
        return notTieAndUnderFour(player1Score, player2Score);
    }

    private String notTieAndUnderFour(int firstPlayerScore,int secondPlayerScore) {
        return  aliasOfScores.get( firstPlayerScore) +
                HYPHE_TEXT + aliasOfScores.get(secondPlayerScore);
    }


    private String overFourCases() {
        int minusResult = Math.abs(player1Score - player2Score);
        if(minusResult == 1){
            return ADVANTAGE_TEXT + playerNameWithMorePoints();
        }
        return WIN_FOR_TEXT + playerNameWithMorePoints();

    }

    private String playerNameWithMorePoints() {
        if(player1Score > player2Score){
            return PLAYER1_TEXT;
        }
        return PLAYER2_TEXT;
    }

    private String tieCases(Integer bothPlayersScore) {
        if(bothPlayersScore >= 3){
            return DEUCE_TEXT;
        }
        return aliasOfScores.get(bothPlayersScore)+"-All";
   }
}
