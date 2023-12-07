package lotto.view;

import static lotto.LottoConstants.ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = "\n";

    public static long getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine().trim();

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
        System.out.println(NEW_LINE + "당첨 번호를 입력해 주세요.");

        String[] inputs = Console.readLine().split(DELIMITER);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String input : inputs) {
            Integer winningNumber = parseIntWithIllegalArgumentException(input.trim());
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
        System.out.println(NEW_LINE + "보너스 번호를 입력해 주세요.");

        String input = Console.readLine().trim();

        return parseIntWithIllegalArgumentException(input);
    }
}
