package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String NEW_LINE = "\n";
    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(NEW_LINE + lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);

            System.out.println(numbers);
        }
    }
}
