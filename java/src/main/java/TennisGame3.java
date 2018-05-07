
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
            return callableFormatOfScore().asString();
        } else {
            return notCallableFormatOfScore().asString();
        }
    }

    private ScoreFormatter notCallableFormatOfScore() {
        String playerWithMostPoints;
        if (isTie())
            return new NotCallabletieFormatter();

        playerWithMostPoints = playerWithMostPoints();
        if(hasAdvantageOfMoreThanOnePoint()){
            return new AdvantageFormatter(playerWithMostPoints);
        }
        return new WinFormatter(playerWithMostPoints);
    }

    private ScoreFormatter callableFormatOfScore() {
        if(isTie()) {
            return new CallableTieFormatter(p1);
        } else {
            return new CallableNoTieFormatter(p1,p2);
        }
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
