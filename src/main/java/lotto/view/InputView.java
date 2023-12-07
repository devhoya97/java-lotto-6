package lotto.view;

import static lotto.LottoConstants.ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public static long getPurchaseAmount() {
        String input = Console.readLine();

        return parseLongWithIllegalArgumentException(input);
    }

    private static Long parseLongWithIllegalArgumentException(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR + "입력을 Long 타입으로 변환할 수 없습니다.");
        }
    }

    public static List<Integer> getWinningNumbers() {
        String[] inputs = Console.readLine().split(DELIMITER);

        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            Integer winningNumber = parseIntWithIllegalArgumentException(input);
            winningNumbers.add(winningNumber);
        }

        return winningNumbers;
    }

    private static Integer parseIntWithIllegalArgumentException(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR + "입력을 Integer 타입으로 변환할 수 없습니다.");
        }
    }

    public static Integer getBonusNumber() {
        String input = Console.readLine();

        return parseIntWithIllegalArgumentException(input);
    }
}
