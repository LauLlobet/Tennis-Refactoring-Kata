public class FormatterFactory {
    public static ScoreFormatter getFormatterFor(int p1, int p2) {
        if (isCallable(p1,p2)) {
            return callableFormatOfScore(p1,p2);
        } else {
            return notCallableFormatOfScore(p1,p2);
        }
    }

    private static ScoreFormatter notCallableFormatOfScore(int p1, int p2) {
        String playerWithMostPoints;
        if (isTie(p1, p2))
            return new NotCallabletieFormatter();
        playerWithMostPoints = playerWithMostPoints(p2, p1);
        if (hasAdvantageOfMoreThanOnePoint(p1, p2)) {
            return new AdvantageFormatter(playerWithMostPoints);
        }
        return new WinFormatter(playerWithMostPoints);
    }

    private static ScoreFormatter callableFormatOfScore(int p1, int p2) {
        if (isTie(p1, p2)) {
            return new CallableTieFormatter(p1);
        } else {
            return new CallableNoTieFormatter(p1, p2);
        }
    }

    private static String playerWithMostPoints(int p2, int p1) {
        return p1 > p2 ? "player1" : "player2";
    }

    private static boolean hasAdvantageOfMoreThanOnePoint(int p1, int p2) {
        return (p1 - p2) * (p1 - p2) == 1;
    }

    private static boolean isTie(int p1, int p2) {
        return p1 == p2;
    }

    private static boolean isCallable(int p1, int p2) {
        return CallPoint.isCallable(p1) && CallPoint.isCallable(p2) && !(p1 + p2 == 6);
    }
}
