
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
        String s;
        if (isCallable()) { // too large step
            return tieCall();
        } else {
            if (isTie())
                return "Deuce";
            s = p1 > p2 ? p1N : p2N;
            return ((p1-p2)*(p1-p2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    private boolean isTie() {
        return p1 == p2;
    }

    private boolean isCallable() {
        return CallPoint.isCallable(p1) && CallPoint.isCallable(p2) && !(p1 + p2 == 6);
    }

    private String tieCall(){
        if(isTie()) {
            return CallPoint.fromPointString(p1) + "-All";
        } else {
            return CallPoint.fromPointString(p1) + "-" + CallPoint.fromPointString(p2);
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
