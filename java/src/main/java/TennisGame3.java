
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (isCallable()) {
            return callableFormatOfScore();
        } else {
            return notCallableFormatOfScore();
        }
    }

    private String notCallableFormatOfScore() {
        String playerWithMostPoints;
        if (isTie())
            return formatNotCallableTie();

        playerWithMostPoints = playerWithMostPoints();
        if(hasAdvantageOfMoreThanOnePoint()){
            return formatToAdvantage(playerWithMostPoints);
        }
        return formatToWin(playerWithMostPoints);
    }

    private String callableFormatOfScore() {
        if(isTie()) {
            return formatToCallableTie();
        } else {
            return formatToCallableNotTie();
        }
    }

    private String formatToWin(String s) {
        return "Win for " + s;
    }

    private String formatToAdvantage(String s) {
        return "Advantage " + s;
    }

    private String formatNotCallableTie() {
        return "Deuce";
    }

    private String formatToCallableNotTie() {
        return CallPoint.fromPointString(p1) + "-" + CallPoint.fromPointString(p2);
    }

    private String formatToCallableTie() {
        return CallPoint.fromPointString(p1) + "-All";
    }

    private String playerWithMostPoints() {
        return p1 > p2 ? p1N : p2N;
    }

    private boolean hasAdvantageOfMoreThanOnePoint() {
        return (p1-p2)*(p1-p2) == 1;
    }

    private boolean isTie() {
        return p1 == p2;
    }

    private boolean isCallable() {
        return CallPoint.isCallable(p1) && CallPoint.isCallable(p2) && !(p1 + p2 == 6);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
