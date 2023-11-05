package lotto.utils;

import java.text.DecimalFormat;

public enum PrintingMessage {
    GET_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    BUYING_MESSAGE("%d개를 구매했습니다."),
    GET_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    PRIZE_MESSAGE("%d개 일치%s(%s원) - %d개"),
    DECIMAL_FORMAT("#,###");

    private String message;

    PrintingMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public String getWithFormat(int number) {
        return String.format(message, number);
    }

    public String getWithFormat(int sameCount, long prizeProfit, int prizeCount) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT.get());
        String formattedPrizeProfit = decimalFormat.format(prizeProfit);
        String bonusMessage = LottoConstant.SPACE.get();
        if (prizeProfit == Prize.SECOND.getPrizeProfit()) {
            bonusMessage = ", 보너스 볼 일치 ";
        }
        return String.format(message, sameCount, bonusMessage, formattedPrizeProfit, prizeCount);
    }
}
