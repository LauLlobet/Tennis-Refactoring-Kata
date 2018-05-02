import java.util.Hashtable;

public class ScoreFormatter {
    public static final String ADVANTAGE_TEXT = "Advantage ";
    public static final String WIN_FOR_PLAYER_TEXT = "Win for ";
    public static final String HYPHE_TEXT = "-";
    public static final String DEUCE_TEXT = "Deuce";
    public static final String PLAYER2_NAME = "player2";
    public static final String PLAYER1_NAME = "player1";
    public static final int LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE = 3;
    public static final int ADVANTAGE_POINT = 1;
    public static final String ALL_DUCE_TEXT = "-All";

    private Hashtable<Integer, String> peculiarNamingForAScore = new Hashtable<Integer, String>(){{
        put(0,"Love");
        put(1,"Fifteen");
        put(2, "Thirty");
        put(3, "Forty");

    }};

    public String formatScore(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return tieCases(player1Score);
        }
        if (player1Score > LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE
                || player2Score > LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE) {

            return advantageOrWinCases(player1Score, player2Score);
        }
        return notTieAndUnderFour(player1Score, player2Score);
    }

    private String notTieAndUnderFour(int firstPlayerScore,int secondPlayerScore) {
        return  peculiarNamingForAScore.get( firstPlayerScore) +
                HYPHE_TEXT + peculiarNamingForAScore.get(secondPlayerScore);
    }

    private String advantageOrWinCases(int p1s, int p2s) {
        int minusResult = Math.abs(p1s - p2s);

        if(minusResult == ADVANTAGE_POINT){
            return ADVANTAGE_TEXT + playerNameWithMorePoints(p1s,p2s);
        }
        return WIN_FOR_PLAYER_TEXT + playerNameWithMorePoints(p1s, p2s);

    }

    private String playerNameWithMorePoints(int p1s, int p2s) {
        if(p1s > p2s){
            return PLAYER1_NAME;
        }
        return PLAYER2_NAME;
    }

    private String tieCases(Integer bothPlayersScore) {
        if(bothPlayersScore < LIMIT_FOR_PECULIAR_NAMING_AND_STARTING_OF_DUCE_SCORE){
            return duceForPeculiarNaming(bothPlayersScore);
        }
        return DEUCE_TEXT;
    }

    private String duceForPeculiarNaming(Integer bothPlayersScore) {
        return peculiarNamingForAScore.get(bothPlayersScore)+ ALL_DUCE_TEXT;
    }
}

/*
3 3 -> DUCE
2 2 -> THIRTY ALL
1 2 -> FIFTEEN THIRTY
2 3 -> THRTY FOURTEE
3 4  -> ADVANTAGE FOR PLAYER
*/
