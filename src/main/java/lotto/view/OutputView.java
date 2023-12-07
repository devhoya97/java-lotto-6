package lotto.view;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.Prize;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String MONEY_PATTERN = "#,###";
    private static final double ROUNDING_MULTIPLIER = 100.0;
    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(NEW_LINE + lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);

            System.out.println(numbers);
        }
    }

    public static void printResult(List<Prize> prizes, double profitRate) {
        StringBuilder message = new StringBuilder();

        message.append("당첨 통계").append(NEW_LINE).append("---").append(NEW_LINE);
        for (Prize prize : Prize.getPrizesExcludingNoPrize()) {
            message.append(prize.getCorrectCount()).append("개 일치 (")
                    .append(getFormattedMoney(prize.getWinningMoney())).append("원) - ")
                    .append(countPrize(prizes, prize)).append("개").append(NEW_LINE);
        }

        message.append("총 수익률은 ").append(roundToTwoDecimalPlaces(profitRate))
                .append("%입니다.").append(NEW_LINE);

        System.out.println(message);
    }

    private static int countPrize(List<Prize> prizes, Prize prize) {
        return Collections.frequency(prizes, prize);
    }

    private static String getFormattedMoney(long money) {
        DecimalFormat formatter = new DecimalFormat(MONEY_PATTERN);
        return formatter.format(money);
    }

    public static String roundToTwoDecimalPlaces(double profitRate) {
        double roundedNumber = Math.round(profitRate * ROUNDING_MULTIPLIER) / ROUNDING_MULTIPLIER;

        return String.format("%.2f", roundedNumber);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
