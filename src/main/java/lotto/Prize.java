package lotto;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int correctCount;
    private final boolean hasBonusNumber;
    private final long winningMoney;

    Prize(int correctCount, boolean hasBonusNumber, long winningMoney) {
        this.correctCount = correctCount;
        this.hasBonusNumber = hasBonusNumber;
        this.winningMoney = winningMoney;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
