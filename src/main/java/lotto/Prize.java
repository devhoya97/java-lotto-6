package lotto;

import java.util.List;

public enum Prize {
    FIRST(6,2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4,50_000),
    FIFTH(3, 5_000),
    NO_PRIZE(0,0);

    private final int correctCount;
    private final long winningMoney;

    Prize(int correctCount, long winningMoney) {
        this.correctCount = correctCount;
        this.winningMoney = winningMoney;
    }

    public static List<Prize> getPrizesExcludingFiveCorrect() {
        return List.of(FIRST, FOURTH, FIFTH);
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
