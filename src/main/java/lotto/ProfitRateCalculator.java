package lotto;

import java.util.List;

public class ProfitRateCalculator {
    private static final int PERCENTAGE_MULTIPLIER = 100;

    public static double calculate(List<Prize> prizes, long money) {
        long totalPrizeMoney = 0;

        for (Prize prize : prizes) {
            totalPrizeMoney += prize.getWinningMoney();
        }

        return (totalPrizeMoney / (double) money) * PERCENTAGE_MULTIPLIER;
    }
}
