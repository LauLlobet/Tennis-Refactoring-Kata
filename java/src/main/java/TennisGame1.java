import java.util.Hashtable;

public class TennisGame1 implements TennisGame {

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
        if (playerName == "player1") {
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
                "-" + aliasOfScores.get(secondPlayerScore);
    }


    private String overFourCases() {
        int minusResult = Math.abs(player1Score - player2Score);
        if(minusResult == 1){
            return "Advantage "+ playerNameWithMorePoints();
        }
        return "Win for " + playerNameWithMorePoints();

    }

    private String playerNameWithMorePoints() {
        if(player1Score > player2Score){
            return "player1";
        }
        return "player2";
    }

    private String tieCases(Integer bothPlayersScore) {
        if(bothPlayersScore >= 3){
            return "Deuce";
        }
        return aliasOfScores.get(bothPlayersScore)+"-All";
   }
}
