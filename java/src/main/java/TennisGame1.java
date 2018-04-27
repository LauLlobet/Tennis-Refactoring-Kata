import java.util.Hashtable;

public class TennisGame1 implements TennisGame {

    public static final int LOVE_CASE = 0;
    public static final int INT = 1;
    public static final int FIFTEEN_ALIAS = INT;
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private Hashtable<Integer, String> aliasOfScores = new Hashtable<Integer, String>(){{
        put(0,"Love");
        put(1,"Fifteen");
        put(2, "Thirty");
        put(3, "Forty");

    }};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2)
        {
            return tieCases();
        }
        if (m_score1>=4 || m_score2>=4)
        {
            return overFourCases();
        }
        return notTieAndUnderFour();
    }

    private String notTieAndUnderFour() {
        String score = "";
        int tempScore = 0;
        tempScore = m_score1;
        score = getScoreAlias(score, tempScore);
        score+="-";
        tempScore = m_score2;
        score = getScoreAlias(score, tempScore);

        return score;
    }

    private String getScoreAlias(String score, int tempScore) {
        return score += aliasOfScores.get(tempScore);
    }

    private String overFourCases() {
        int minusResult = m_score1-m_score2;
        if (minusResult==1) return "Advantage player1";
        else if (minusResult ==-1) return "Advantage player2";
        else if (minusResult>=2) return "Win for player1";
        return "Win for player2";
    }

    private String tieCases() {
        switch (m_score1)
        {
            case 0:
                     return "Love-All";
            case 1:
                    return  "Fifteen-All";
            case 2:
                    return "Thirty-All";
            default:
                    return "Deuce";
        }
    }
}
