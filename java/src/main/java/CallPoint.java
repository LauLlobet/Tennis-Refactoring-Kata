public enum CallPoint {
    LOVE(0,"Love"),FIFTEEN(1,"Fifteen"),THIRTY(2,"Thirty"),FORTY(3,"Forty");

    private final int points;
    private String call;

    CallPoint(int points, String call) {
        this.points = points;
        this.call = call;
    }


    public static String fromPointString(int point) {
        return values()[point].toString();
    }

    @Override
    public String toString() {
        return call;
    }
}
