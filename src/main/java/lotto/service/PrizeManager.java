package lotto.service;

import java.util.Map;
import lotto.domain.wrapper.PurchaseAmount;
import lotto.utils.Prize;

public class PrizeManager {
    private final Map<Prize, Integer> prizeCounts;

    public PrizeManager(Map<Prize, Integer> prizeCounts) {
        this.prizeCounts = prizeCounts;
    }

    public int getPrizeCount(Prize prize) {
        return prizeCounts.get(prize);
    }

    public double getProfitRate(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculateProfitRate(getAllPrizeProfit());
    }

    private long getAllPrizeProfit() {
        long allPrizeProfit = 0;
        for (Prize prize : prizeCounts.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * prizeCounts.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }
}
