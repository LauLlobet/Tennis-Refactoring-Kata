package approach2;

public enum PointCall {
    LOVE(0,"Love"), FIFTEEN(1,"Fifteen"), THIRTY(2,"Thirty"), FOURTY(3,"Forty");

    private final int points;
    private final String call;

    PointCall(int points, String call) {
        this.points = points;
        this.call = call;
    }

    public static PointCall fromPoints(int points){
        return values()[points];
    }

    @Override
    public String toString() {
        return call;
    }

    public static boolean isPointCall(int points) {
        return points < values().length;
    }
}
