package lotto.view;

import static lotto.LottoConstants.ERROR;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static long getPurchaseAmount() {
        String input = Console.readLine();

        return parseLongWithIllegalArgumentException(input);
    }

    private static Long parseLongWithIllegalArgumentException(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR + "구입 금액을 Long 타입으로 변환할 수 없습니다.");
        }
    }
}
